package com.example.learningplatform;

import java.util.List;

public class JsonX {

    public class Base {
        public String msg;
        public int code;
    }

    public class LoginX extends Base {
        public String token;
    }

    public class Pinformation extends Base {
        public User user;
    }

    public class User {
        public int userId;
        public String userName;
        public String nickName;
        public String email;
        public String phonenumber;
        public String sex;
        public String avatar;
        public int idCard;
        public int balance;
        public int score;

    }


    //城市失物招领模块


    public class CitySw {

        private String msg;
        private int code;
        private List<Data> data;

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public List<Data> getData() {
            return data;
        }
    }

    public class Params {

    }

    public class MetroFoundList {

        private String searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private Params params;
        private int id;
        private String imgUrl;
        private String foundTime;
        private String foundPlace;
        private String claimPlace;

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getRemark() {
            return remark;
        }

        public void setParams(Params params) {
            this.params = params;
        }

        public Params getParams() {
            return params;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setFoundTime(String foundTime) {
            this.foundTime = foundTime;
        }

        public String getFoundTime() {
            return foundTime;
        }

        public void setFoundPlace(String foundPlace) {
            this.foundPlace = foundPlace;
        }

        public String getFoundPlace() {
            return foundPlace;
        }

        public void setClaimPlace(String claimPlace) {
            this.claimPlace = claimPlace;
        }

        public String getClaimPlace() {
            return claimPlace;
        }


    }
    public class Data {

        private String publishDate;
        private List<MetroFoundList> metroFoundList;

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setMetroFoundList(List<MetroFoundList> metroFoundList) {
            this.metroFoundList = metroFoundList;
        }

        public List<MetroFoundList> getMetroFoundList() {
            return metroFoundList;
        }

    }
}
