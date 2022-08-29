ipdatacloud
=============

## [官网](https://www.ipdatacloud.com)

###### ip查询 ipv4查询 ipv6查询

用于识别国家、地区、城市、经纬度、邮政编码、时区、连接速、ISP、域名、
IDD国家代码、区号、气象站数据、区号气象数据、移动网络代码（MNC)、
移动国家代码（MCC）、移动运营商、海拔、使用类型地址类型、广告类型。

>1. 编码：UTF8 字节序：Little-Endian
>2. 性能：每秒解析1000w+ 查询非常快
##### 返回字符串
洲|国家|省份|城市|区县|运营商|区域代码|国家英文|国家英文简写|经度|纬度|海拔|邮编|城市代码|气象站|ASN码

###### 离线库返回信息
```
{
    "continent":"亚洲",
    "country":"中国",
    "country_english":"China",
    "country_code":"CN",
    "province":"江苏",
    "city":"南京",
    "district":"",
    "area_code":"320100",
    "isp":"电信",
    "ip":"180.101.49.11",
    "longitude":"118.767413",
    "latitude":"32.041544",
    "elevation":"7",
    "weather_station":"CHXX0099",
    "zip_code":"210000",
    "is_proxy":"-",
    "proxy_type":"-",
    "city_code":"025",
    "asn":"-",
}
```
