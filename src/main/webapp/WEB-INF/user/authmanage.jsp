<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<title>权限</title>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript" src="${ctx}/common/layui/layui.js"></script>
</head>
<body>
    <div class="layui-collapse">
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">权限信息-查询条件</h2>
            <div class="layui-colla-content layui-show">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px; padding: 5px">
                    <legend>权限信息-查询条件</legend>
                    <form class="layui-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">编号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="role_code" placeholder="请输入账号" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label">角色</label>
                            <div class="layui-input-inline">
                                <input type="text" name="role_name" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label"></label> 
                            <span> 
                            <input type="button" class="layui-btn" lay-submit lay-filter="search" value="查询" /> 
                            <input type="reset" class="layui-btn" value="重置" /> 
                            
                            </span>
                        </div>
                    </form>
                    
                </fieldset>
            </div>
        </div>
    </div>
    <table id="demo" lay-filter="test"></table>
    <script type="text/javascript" src="${ctx}/common/layui/layui.all.js"></script>
<script>
refresh();
function refresh(){
    layui.use('table', function(){
      var table = layui.table;
      //初始化--方法渲染
      table.render({
        elem: '#demo'//绑定容器
        ,url: con.app+'/role/getRoleListAll' //数据接口//默认会自动传递两个参数：?page=1&limit=30
        ,height: 'full-230'//容器高度
        ,request: {
          pageName: 'pageIndex' //页码的参数名称，默认：page
          ,limitName: 'pageLimit' //每页数据量的参数名，默认：limit
        }   
        ,where:{role_code:$("input[name='role_code']").val(),role_name:$("input[name='role_name']").val()}
        ,page: true //开启分页
        ,cols: [[ //表头
          {title: '全选',type:'checkbox',fixed: 'left'}//LAY_CHECKED:true
          ,{title: '序号', type:'numbers', fixed: 'left'}
          ,{field: 'id', title: '主键ID', width:80, sort: true, fixed: 'left',align:'right'}
          ,{field: 'role_code', title: '账号', width:120}
          ,{field: 'role_name', title: '姓名', width:120, sort: true}
          ,{field: 'parent_code', title: '上级', width:220}
          ,{title: '操作1', width:180,toolbar:'#barDemo'}
          
        ]]
      });
     });
      tool();
      //uploadExcel();
}
function tool(){
    //监听工具条
    var table = layui.table;
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
      var data = obj.data; //获得当前行数据
      var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
      var tr = obj.tr; //获得当前行 tr 的DOM对象
     
      if(layEvent === 'upd'){ //编辑
    	  openLayer('/menu/menuupd?role_code='+data.role_code,refresh);
        //同步更新缓存对应的值
//         obj.update({
//           name: '123'
//           ,pass: 'xxx'
//           ,code: 'QWER'
//         });
//         refresh();
      }
    });
 
}
form.on('submit(search)', function(data) {
    refresh();
});


layui.use(['element'], function () {
    var element = layui.element;// 操作对象
});
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="upd">编辑</a>
</script>
</body>
</html>