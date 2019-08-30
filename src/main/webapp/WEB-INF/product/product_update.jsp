
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
                <label class="layui-form-label">编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="code" placeholder="请输入编号"
                        autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="required"
                        placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">商品单价</label>
                <div class="layui-input-inline">
                    <input type="text" name="cost" lay-verify="required"
                        placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品库存</label>
                <div class="layui-input-inline">
                    <input type="text" name="sum" lay-verify="required"
                        placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input type="button" class="layui-btn" lay-submit lay-filter="upd"
                    value="修改"> <input type="button" class="layui-btn "
                    value="取消" onclick="closeThis()">
            </div>
        </div>
        </form>
    </div>
    <script type="text/javascript">
    
            var id='${list.id}';
        init();
    
        function init() {
        	var code='${list.code}';
            var name='${list.name}';
            var sum='${list.sum}';
            var cost='${list.cost}';
            
              $("input[name='code']").val(code), 
              $("input[name='name']").val(name),
              $("input[name='sum']").val(sum),
              $("input[name='cost']").val(cost);
            };

            formSubmit('/pro/updpro?id='+id, 'submit(upd)', 'text',
                    function(data) {
                        if (data == 1) {
                            layer.msg("修改成功");
                            closeThis(3000);
                        } else {
                            layer.msg("修改失败");
                        }
                    });
        
    </script>
</body>
</html>