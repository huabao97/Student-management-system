import axios from "axios";

const request=axios.create({
  baseURL:"http://localhost:8080/ems/emp",
  timeout:5000
});
//使用拦截器 请求拦截器 响应拦截器
request.interceptors.request.use(config=>{
  //请求过程中的公共处理操作
  console.log("请求拦截器！");
  return config;
})

//使用拦截器 响应拦截器
request.interceptors.response.use(response=>{
  console.log("响应拦截器！ 正确响应情况下的处理 ")
  return response;
},error => {
  console.log("响应拦截器 错误响应情况下的处理")
})

//将对象暴露出去 公开
export default request;
