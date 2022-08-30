package main

import (
	"fmt"
	"ip-go/pkg/ipdatacloud"
	"strings"
)

type IpInfos struct {
	Continent      string `json:"continent"`       //洲
	Country        string `json:"country"`         //国家/地区
	CountryEnglish string `json:"country_english"` //国家/地区英文
	CountryCode    string `json:"country_code"`    //国家/地区英文简写
	Province       string `json:"province"`        //省份
	City           string `json:"city"`            //城市
	District       string `json:"district"`        //区县
	AreaCode       string `json:"area_code"`       //区域代码
	Isp            string `json:"isp"`             //运营商
	Longitude      string `json:"longitude"`       //经度
	Latitude       string `json:"latitude"`        //纬度
	LocalTime      string `json:"local_time"`      //本地时间
	Elevation      string `json:"elevation"`       //海拔
	WeatherStation string `json:"weather_station"` //气象站
	ZipCode        string `json:"zip_code"`        //邮编
	CityCode       string `json:"city_code"`       //城市代码
	Asn            string `json:"asn"`
}

func main() {
	str, _ := ipdatacloud.GetObject().Get("220.162.31.109")
	infos := strings.Split(str, "|")
	if len(infos) < 14 {
		return
	}
	ips := &IpInfos{
		Continent:      infos[0],
		Country:        infos[1],
		Province:       infos[2],
		City:           infos[3],
		District:       infos[4],
		Isp:            infos[5],
		AreaCode:       infos[6],
		CountryEnglish: infos[7],
		CountryCode:    infos[8],
		Longitude:      infos[9],
		Latitude:       infos[10],
		Elevation:      infos[11],
		ZipCode:        infos[12],
		CityCode:       infos[13],
		WeatherStation: infos[14],
		Asn:            infos[15],
	}
	fmt.Printf("%+v \n", ips)
}
