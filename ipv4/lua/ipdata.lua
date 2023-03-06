local ipdata = { prefStart = {}, prefEnd = {},
                 endArr = {}, addrArr = {},
                 file = {}, _version = "0.1.2" }

function unpackInt4byte(a, b, c, d)
    return (a & 0xFF) | ((b << 8) & 0xFF00) | ((c << 16) & 0xFF0000) | ((d << 24) & 0xFF000000)
end

function fsize(file)
    local current = file:seek() -- 获取当前位置
    local size = file:seek("end") -- 获取文件大小
    file:seek("set", current) -- 恢复位置
    return size
end

function redaFileBytes(file, length, off)
    file:seek("set", off)
    local str = file:read(length)
    return { str:byte(1, #str) }
end

function ipdata.LoadFile(path)
    local sizeData = {}

    ipdata.file = io.open(path, "rb")

    for k = 1, 256 do
        local i = k * 8 + 4
        sizeData = redaFileBytes(ipdata.file, 8, i)
        ipdata.prefStart[k] = unpackInt4byte(sizeData[1], sizeData[2], sizeData[3], sizeData[4])
        ipdata.prefEnd[k] = unpackInt4byte(sizeData[5], sizeData[6], sizeData[7], sizeData[8])
    end
    -- 文件大小
    sizeData = redaFileBytes(ipdata.file, 4, 0)
    local recordSize = unpackInt4byte(sizeData[1], sizeData[2], sizeData[3], sizeData[4])
    -- print(recordSize)
    --
    for i = 1, recordSize do
        local j = 2052 + (i * 9)
        sizeData = redaFileBytes(ipdata.file, 9, j)
        local endipnum = unpackInt4byte(sizeData[1], sizeData[2], sizeData[3], sizeData[4])
        local offset = unpackInt4byte(sizeData[5], sizeData[6], sizeData[7], sizeData[8])
        local length = sizeData[9]
        ipdata.endArr[i] = endipnum
        ipdata.file:seek("set", offset)
        ipdata.addrArr[i] = ipdata.file:read(length)
    end
end

function ip2int(ip)
    local o1, o2, o3, o4 = ip:match("(%d+)%.(%d+)%.(%d+)%.(%d+)")
    local num = 2 ^ 24 * o1 + 2 ^ 16 * o2 + 2 ^ 8 * o3 + o4
    return math.floor(num)
end

function ipdata.Search(low, high, k)
    local M = 0
    while low <= high
    do
        local mid = math.floor((low + high) / 2)
        local endipNum = ipdata.endArr[mid]
        if endipNum == nil then
            break
        end
        if endipNum >= k then
            M = mid
            if mid == 0 then
                break
            end
            high = mid - 1
        else
            low = mid + 1
        end
    end
    return M
end

function ipdata.FindIP(ip)
    local ips = { string.match(ip, "([^.]+).?") }
    local prefix = tonumber(ips[1])

    local low = ipdata.prefStart[prefix]
    local high = ipdata.prefEnd[prefix]
    local intIP = ip2int(ip)

    -- print("FindIP", ip, prefix, intIP)
    local cur = 0
    if low == high then
        cur = low
    else
        cur = ipdata.Search(low, high, intIP)
    end
    if cur == 100000000 then
        return "0.0.0.0"
    else
        return ipdata.addrArr[cur]
    end
end

return ipdata
