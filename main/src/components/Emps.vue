<template>
  <div>
    <h3>{{ msg }}</h3>
    <hr/>
    <h4><a href="javascript:;">添加学生</a></h4>
    <table border="1px" cellpadding="0px" width="100%">
      <tr>
        <td>编号</td>
        <td>名称</td>
        <td>薪资</td>
        <td>年龄</td>
        <td>操作</td>
      </tr>
      <tr v-for="(emp,index) in emps" :key="emp.id">
        <td>{{ index + 1 }}</td>
        <td>{{ emp.name }}</td>
        <td>{{ emp.salary }}</td>
        <td>{{ emp.age }}</td>
        <td><a href="javascript:;" @click.prevent="del(emp.id)">删除</a> <a href="javascript:;"
                                                                          @click.prevent="queryOne(emp.id)">修改</a></td>
      </tr>
    </table>
    <hr/>
    <h3>{{ fun }}学生信息</h3>
    <form>
      <input type="hidden" readonly v-model="emp.id"><br/>
      名称：<input type="text" v-model="emp.name"><br/>
      薪资：<input type="text" v-model="emp.salary"><br/>
      年龄：<input type="text" v-model="emp.age"><br/>
      <input type="submit" v-model="fun" @click="insert()"><br/>
    </form>

  </div>
</template>

<script>
import axios from "axios";
import request from "../../utils/request";


export default {
  name: "Emps",
  data() {
    return {
      msg: "学生管理系统",
      emps: [],
      emp: {},
      fun: "添加"
    }
  },
  methods: {
    //展示所有
    quallAll() {
      //发送请求 接收相应数据 将数据交给组件
      request.get("/queryAll").then(response => {
        console.log(response.data);
        this.emps = response.data
      })
    },
    //数据回显
    queryOne(id) {
      //先将fun中的添加换为为修改
      this.fun="修改";
      if(window.confirm("你确定修改吗？")){
        request.get("/queryOne?id=" + id).then((emp) => {
          this.emp=emp.data;
          this.quallAll();
        })
      }
    },
    //添加员工
    insert() {
      //接收数据  双向绑定
      console.log(this.emp);
      if(window.confirm("确认添加学生吗")){
        request.post("/add", this.emp).then(() => {
          this.quallAll();
          this.emp = {}
        })
      }
    },
    //根据id删除
    del(id) {
      if (window.confirm("你确定添加/修改这个学生信息吗？")) {
        request.get("/delete?id=" + id).then(() => {
          this.quallAll();
        })
      }
    }
  },
  created() {
    this.quallAll();
  }
}
</script>

<style scoped>

</style>
