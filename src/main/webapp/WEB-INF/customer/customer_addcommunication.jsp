
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/header.jsp"%>
<style type="text/css">
.main_div {
    margin: 15px;
}
</style>
</head>
<body>

    <div class="main_div">
        <form id="from_add" class="layui-form layui-form-pane" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">用户</label>
                <div class="layui-input-inline">
                    <input type="text" name="cust_code" placeholder="请输入编号"
                        autocomplete="off" class="layui-input">
                </div>
            </div>

            
            <div class="layui-inline">
                <label class="layui-form-label">时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="TIME" class="layui-input" id="test5"
                        placeholder="yyyy-MM-dd HH:mm:ss">
                </div>
            </div>
            
            <div class="layui-form-item">
                <label class="layui-form-label">内容</label>
                <div class="layui-input-inline">
                    <input type="text" name="content" placeholder="最大数量50"
                        autocomplete="off" class="layui-input" maxlength="50">
                </div>
            </div>
            
            <div class="layui-form-item">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-inline">
                    <input type="text" name="type" placeholder="请输入编号"
                        autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="button" class="layui-btn" onclick="javascript:add();"
                        value="添加"> <input type="button" class="layui-btn "
                        value="取消" onclick="closeThis()">
                </div>
            </div>
        </form>
    </div>
    <script type="text/javascript" src="/dall/common/layui/layui.all.js"></script>
    <script type="text/javascript">
    
        //form.render("select");
        //日期时间选择器
        var laydate = layui.laydate;
        laydate.render({
            elem : '#test5',
            type : 'datetime'
        });
        function add() {
            $.ajax({
                url : "${ctx}/cus/add",
                data : $('#from_add').serialize(),
                type : "post",
                dataType : "json",
                success : function(data) {
                    if (data == 0) {
                        layer.msg('添加成功');
                        closeThis(3000);
                    } else {
                        layer.msg('添加失败');
                    }
                }
            });

        }

        //      formSubmit('/pro/add', 'submit(add)', 'text', function(data) {
        //          if (data == 0) {
        //              layer.msg('添加成功');
        //              closeThis(3000);
        //          } else if (data == 1) {
        //              layer.msg('已存在');
        //          } else {
        //              layer.msg('添加失败');
        //          }
        //      });
    </script>
</body>
</html>