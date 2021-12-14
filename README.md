# Android 

## Fragment

Fragment**是一种可以嵌入在活动中的UI片段，能够让程序更加合理和充分地利用大屏幕的空间，出现的初衷是为了适应大屏幕的平板电脑，可以将其看成一个小型Activity，又称作**Activity片段。

- Fragment依赖于Activity，不能独立存在
- 一个Activity可以有多个Fragment
- 一个Fragment可以被多个Activity重用
- Fragment有自己的生命周期，并能接收输入事件
- 可以在Activity运行时动态地添加或删除Fragment

### Fragment自己的生命周期

![img](https://upload-images.jianshu.io/upload_images/8133609-050a142392d07e50.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/538/format/webp)

### 简单使用Fragment

创建一个xml 作为fragment的布局

自定义Fragment类，继承Fragment或其子类，重写`onCreateView()`

```java
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View viewlayout=
        inflater.inflate(R.layout.login_fragment,container,false);
        Re_but=viewlayout.findViewById(R.id.register_but);
        Login_but=viewlayout.findViewById(R.id.login_but);
        Us_edit=viewlayout.findViewById(R.id.us_edit);
        Pa_edit=viewlayout.findViewById(R.id.pa_edit);
        return viewlayout;

    }
```

重新写 onAttach() 绑定Context 用于设置接口

Fragment 内的 事件 重写onActivityCreated() 中实现



### 跟新Framnet

获得FragmentManager对象，通过`getSupportFragmentManager()`

获得FragmentTransaction对象，通过`fm.beginTransaction()`

调用`add()`方法或者`repalce()`方法加载Fragment；

调用`commit()`方法提交事务

```java
private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = 				               fragmentManager.beginTransaction();   // 开启一个事务
        transaction.replace(R.id.fragment2, fragment);
        transaction.commit();
    }
```



### Fragment 与Activity 通信

Activity 可以使用构造函数 传参，

或者使用`setArguments(Bundle bundle)`方式添加

在Fragment 中定义interface

Fragment可以通过 接口与Activity 通信













### Gson

将json 实例化 进行操作

传入一个 实例类



```java
Gson gson=new Gson();
JsonX.CitySw citySw=gson.fromJson(data,JsonX.CitySw.class);
```

![image-20211212162753102](C:\Users\peiniwan\AppData\Roaming\Typora\typora-user-images\image-20211212162753102.png)



定义类:**类的成员变量与json 项名字相对应**

set()方法可有 可无

可以给变量public修饰符 不需要get方法

```java
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
```

获取对应变量 如第一条数据的发现时间:

```java
Gson gson=new Gson();
JsonX.CitySw citySw=gson.fromJson(data,JsonX.CitySw.class);
citytext.setText(citySw.getData().get(0).getMetroFoundList().get(0).getFoundTime());
```

 