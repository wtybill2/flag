<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>login</title>
<%@ include file="/common/header.jsp"%>
<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/component.css" />
<!--[if IE]>
<script src="${ctx}/static/back/js/html5.js"></script>
<![endif]-->
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>欢迎登陆</h3>
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
						<img style="left: 295px; top: 312px; position: absolute;"
							src="${pageContext.request.contextPath}/user/images/imagecode"
							onclick="this.src='${pageContext.request.contextPath}/user/images/imagecode?'+Math.random();">
					</form>
					<div class="mb2">
						<a class="act-but submit" href="javascript:;"
							onclick="submitFrom()" style="color: #FFFFFF">登录</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script src="${ctx}/js/TweenLite.min.js"></script>
	<script src="${ctx}/js/EasePack.min.js"></script>
	<script src="${ctx}/js/rAF.js"></script>
	<script src="${ctx}/js/demo-1.js"></script>
	<script type="text/javascript">
		/* function getVerify(obj){
		    obj.src = ${ctx} + "/user/getVerify?"+Math.random();
		} */
		function submitFrom() {
			var AuthCode=$("input[name='AuthCode']").val();
			var code=$("input[name='code']").val();
			var role=$("select[name='role']").val();
			$.ajax({
				type : "post",
                url : con.app + "/user/checkcode",
                data : {AuthCode:AuthCode},
                dataType : "text",
                success : function(data) {
                    if (data == 1) {
                    	$.ajax({
                            type : "post",
                            url : con.app + "/user/loginsuccess",
                            data : $("#login_from").serialize(),
                            dataType : "text",
                            success : function(datao) {
                            	
                                if (datao == 0) {
                                    location.href = con.app + "/menu/getMenu?code="+code+"&role="+role;
                                } else if (datao == 3) {
                                    layer.msg("您角色不符")
                                } else {
                                    layer.msg("登录失败");
                                }
                            }
                        })
                    
                    } else {
                    	layer.msg(data);
                    }
                }
                	
                	
				
			})
			
		}
	</script>



</body>
</html>