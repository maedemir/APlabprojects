package com.company;

public class Music {
    private String singer ;
    private String address;
    private String publishYear;

    /**
     * setting singer's name
     * @param name name of singer
     */
    public void setSinger(String name){
        this.singer=name;
    }

    /**
     *
     * @return name of singer
     */
    public String getSinger(){
        return singer;
    }

    /**
     * to set file address
     * @param fileAddress address of file
     */
    public void setAddress(String fileAddress){
        address = fileAddress;
    }

    /**
     *
     * @return address of file
     */
    public String getAddress(){
        return address;
    }

    /**
     * sets publish year
     * @param year
     */
    public void setPublishYear(String year){
        publishYear = year;
    }

    /**
     * returns publish year!
     * @return
     */
    public String getPublishYear() {
        return publishYear;
    }
}
