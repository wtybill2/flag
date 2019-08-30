<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>register</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/css/component.css" />




</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎注册</h3>
						<form action="#" name="f" method="post" id="login_from">
                        <div class="input_outer">
                            <span class="u_user"></span>
                            <select class="text" style="color:green !important;font-size:16px" name="role">
                            <option value="sell">销售人员</option>
                            <option value="chargemanager">分管经理</option>
                            <option value="generalmanager">总经理</option>
                            </select>
                        </div>
                        <div class="input_outer">
                            <span class="u_user"></span> <input id="username" name="name"
                                class="text" style="color: #FFFFFF !important" type="text"
                                placeholder="请输入姓名">
                        </div>
                        <div class="input_outer">
                            <span class="u_user"></span> <input id="usercode" name="code"
                                class="text" style="color: #FFFFFF !important" type="text"
                                placeholder="请输入账户">
                        </div>
                        <div class="input_outer">
                            <span class="us_uer"></span> <input id="password" name="pass"
                                class="text"
                                style="color: #FFFFFF !important; position: absolute; z-index: 100;"
                                value="" type="password" placeholder="请输入密码">
                        </div>
                        <!-- 验证码 -->
                        <div class="input_outer">
                            <span class="us_uer"></span> <input type="text" name="AuthCode"
                                class="text"
                                style="color: #FFFFFF !important; position: absolute; z-index: 100;"
                                placeholder="请输入验证码" autocomplete="off" class="layui-input">

                        </div>
                        <img style="left: 295px; top:428px; position: absolute;"
                            src="${pageContext.request.contextPath}/user/images/imagecode"
                            onclick="this.src='${pageContext.request.contextPath}/user/images/imagecode?'+Math.random();">
                    </form>
							<div class="mb2">
							<a class="act-but submit" href="javascript:;" onclick="submitFrom()" style="color: #FFFFFF">确认注册</a>
							</div>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="${ctx}/js/TweenLite.min.js"></script>
		<script src="${ctx}/js/EasePack.min.js"></script>
		<script src="${ctx}/js/rAF.js"></script>
		<script src="${ctx}/js/demo-1.js"></script>
		
		<script src="${ctx}/common/jquery-1.11.1.js"></script>
		<script src="${ctx}/common/layui/layui.all.js"></script>
		<script src="${ctx}/common/mylayer.js"></script>
		<script src="${ctx}/common/util.js"></script>
		<script src="${ctx}/common/js/common.js"></script>
		<!-- layui必备 -->
		
		
		<!-- 登陆验证 -->
		<script type="text/javascript">
			function submitFrom(){
				var password = $("#password").val();
				//密码不为空
				if(util.isNull(password)){
					mylayer.errorMsg("密码不能为空");
					return;
				}
				//提交表单
				$.ajax({
					url : "${ctx}/user/add",
					type : "post",
					dataType : "json",
					data : $("#login_from").serialize(),
					success : function(data){
						console.log(data);
						if(data==1){//resp的状态==0
							//layer.msg("注册成功");
							mylayer.confirm("注册成功，是否跳转到主界面?","${ctx}/user/index");
						}else if(data==0){
							mylayer.errorMsg("注册失败");
						}else if(data==2){
							layer.msg("账号已存在");
						}
					}
				});
			}
			
		//验证数据库重名的
		function checkName(){
			var username = $("#username").val();
			//用户名不为空
			if(util.isNull(username)){
				mylayer.errorMsg("用户名不能为空");
				return;
			}
			//用户名格式
			var pattrn = /^[0-9a-zA-Z]{4,8}$/;
			if(!pattrn.test(username)){
				mylayer.errorMsg("用户名格式不正确，请输入4-8位数字或字母");
				return;
			}
			
			
			var username = document.getElementById("username").value;
			
		}
		</script>
		
	</body>
</html>