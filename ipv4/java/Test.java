package v4;

public class Test {

    private String continent;//洲
    private String country;//国家/地区
    private String countryEnglish;//国家/地区英文
    private String countryCode;//国家/地区英文简写
    private String province;//省份
    private String city;//城市
    private String district;//区县
    private String areaCode;//区域代码
    private String isp;//运营商
    private String longitude;//经度
    private String latitude;       //纬度
    private String elevation;      //海拔
    private String weatherStation; //气象站
    private String zipCode;      //邮编
    private String cityCode;    //城市代码
    private String asn;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryEnglish() {
        return countryEnglish;
    }

    public void setCountryEnglish(String countryEnglish) {
        this.countryEnglish = countryEnglish;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(String weatherStation) {
        this.weatherStation = weatherStation;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAsn() {
        return asn;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }


    @Override
    public String toString() {
        return "Test{" +
                "continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                ", countryEnglish='" + countryEnglish + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", isp='" + isp + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", elevation='" + elevation + '\'' +
                ", weatherStation='" + weatherStation + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", asn='" + asn + '\'' +
                '}';
    }

    public Test(String continent, String country, String province, String city, String district, String isp, String areaCode, String countryEnglish, String countryCode, String longitude, String latitude, String elevation, String zipCode, String cityCode, String weatherStation, String asn) {
        this.continent = continent;
        this.country = country;
        this.countryEnglish = countryEnglish;
        this.countryCode = countryCode;
        this.province = province;
        this.city = city;
        this.district = district;
        this.areaCode = areaCode;
        this.isp = isp;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        this.weatherStation = weatherStation;
        this.zipCode = zipCode;
        this.cityCode = cityCode;
        this.asn = asn;
    }

    public static void main(String[] args) {

        Ip ip = Ip.getInstance();
        String Str = ip.Get("220.162.31.109");
        String[] split = Str.split("\\|");
        if (split.length < 14){
            return;
        }
        Test test = new Test(split[0],split[1],split[2],split[3],split[4],
                split[5],split[6],split[7],split[8],split[9],split[10],split[11]
                ,split[12],split[13],split[14],split[15]);
        System.out.println(test.toString());

    }
}


