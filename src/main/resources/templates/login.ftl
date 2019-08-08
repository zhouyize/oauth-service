<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>统一认证登录平台</title>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="https://cdn.bootcss.com/vue/2.5.17/vue.min.js"></script>
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>

<body>
<div class="login-box" id="app" >
   <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-position="left" label-width="0px" class="demo-ruleForm login-container">
    <h2 class="title" >统一认证登录平台</h2>
    <el-form-item prop="username">
      <el-input type="text" v-model="ruleForm.username" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="ruleForm.password" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width:100%; text-align:center;">
      <el-button type="primary" style="width:47%;" @click="resetForm('ruleForm')">重 置</el-button>
      <el-button type="primary" style="width:47%;" @click="submitForm('ruleForm')" :loading="loading">登 录</el-button>
    </el-form-item>
  <el-form>
</div> 
</body>
 
<script type="text/javascript">
    new Vue({
        el : '#app',
        data :function() { 
       		return {   
				ruleForm: {
				  name:'',
		          username: '',
		          password: ''  
		        },
		        loading: false,
		        rules: {
		          name: [
            		{ required: true, message: '请输入活动名称', trigger: 'blur' }
         	 	  ],
		          username: [
		            { required: true, message: '请输入用户名', trigger: 'blur' }
		          ],
		          password: [
		            { required: true, message: '请输入密码', trigger: 'blur' }
		          ],
		     	}     	
        	}
       	},
        methods : {
        	submitForm(formName) {
        		let self=this;
        		self.$refs[formName].validate((valid) => {
		          if (valid) {
		            alert(valid);
		            var formData = new FormData();
		            formData.append('username', self.ruleForm.username)
        			formData.append('password', self.ruleForm.password)
        			formData.append('grant_type', 'password')
		            axios({
				        method: "POST",
				        url: `oauth/token`,
				        data: formData,
				        headers: {
				            Accept: 'application/json',
        					'Content-Type': 'application/json; charset=utf-8',
          					'Authorization': 'Basic U2FtcGxlQ2xpZW50SWQ6c2VjcmV0'
				        }
				    }).then(function(res) {
				    	console.log(window.location)
				    	debugger
				    	// window.location.href="https://baidu.com";
				    });
		          } else {
		            console.log('error submit!!');
		            return false;
		          }
	        	});
      		},
     		resetForm(formName) {
        		this.$refs[formName].resetFields();
      		}
        }
    })
    
</script>

<style lang="scss" scoped>
  .login-container {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 100px auto;
    width: 320px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .title {
      margin: 0px auto 20px auto;
      text-align: center;
      color: #505458;
    }
</style>

</html>