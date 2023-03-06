local ip = require('ipdata')
ip.LoadFile("ipdatacloud_idc.dat")
local findIp = ip.FindIP("1.27.226.1")
print(findIp)
