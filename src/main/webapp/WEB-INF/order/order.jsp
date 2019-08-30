<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<title>数据表格</title>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript" src="${ctx}/common/layui/layui.js"></script>
</head>
<body>
    <div class="layui-collapse">
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">用户信息-查询条件</h2>
            <div class="layui-colla-content layui-show">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px; padding: 5px">
                    <legend>用户信息-查询条件</legend>
                    <form class="layui-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="cust_code" placeholder="请输入账号" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label">商品编号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="prod_code" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label"></label> 
                            <span> 
                            <input type="button" class="layui-btn" lay-submit lay-filter="search" value="查询" /> 
                            <input type="reset" class="layui-btn" value="重置" /> 
                            <input type="button" class="layui-btn" value="添加" onclick="openAdd()" />
                            </span>
                        </div>
                    </form>
                    <div class="layui-form-item">
                    <label class="layui-form-label"></label>
                        <input type="button" class="layui-btn" value="导出Excel" onclick="exportExcel()" />
                        <input type="button" class="layui-btn layui-btn-normal" value="下载模板" onclick="exportExcelTpl()" />
                        <input type="button" class="layui-btn" id="test9" value="上传文件" />
                    </div>
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
        ,url: con.app+'/order/getList' //数据接口//默认会自动传递两个参数：?page=1&limit=30
        ,height: 'full-230'//容器高度
        ,request: {
          pageName: 'pageIndex' //页码的参数名称，默认：page
          ,limitName: 'pageLimit' //每页数据量的参数名，默认：limit
        }   
        ,where:{cust_code:$("input[name='cust_code']").val(),prod_code:$("input[name='prod_code']").val()}
        ,page: true //开启分页
        ,cols: [[ //表头
          {title: '全选',type:'checkbox',fixed: 'left'}//LAY_CHECKED:true
          ,{title: '序号', type:'numbers', fixed: 'left'}
          ,{field: 'id', title: '主键ID', width:80, sort: true, fixed: 'left',align:'right'}
          ,{field: 'cust_code', title: '用户', width:120}
          ,{field: 'prod_code', title: '商品', width:120, sort: true}
          ,{field: 'count', title: '数量', width:220}
          ,{field: 'TIME', title: '时间', width:220}
          ,{field: 'status', title: '状态', width:220}
          ,{title: '操作1', width:180,toolbar:'#barDemo'}
        ]]
      });
     });
      tool();
      uploadExcel();
}
function tool(){
    //监听工具条
    var table = layui.table;
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
      var data = obj.data; //获得当前行数据
      var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
      var tr = obj.tr; //获得当前行 tr 的DOM对象
     
      if(layEvent === 'sel'){ //查看
          layer.msg("查看123123")
      } else if(layEvent === 'del'){ //删除
        layer.confirm('真的删除行么', function(index){
          obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
          layer.close(index);
          //向服务端发送删除指令
        });
      } else if(layEvent === 'upd'){ //编辑
          layer.msg("编辑");  
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
function openAdd(){
     openLayer('/order/getaddlist',refresh)
//location.href='${ctx}/pro/proadd';
}
function exportExcel(){
    window.location.href = '${ctx}/pro/exportExcel'; 
}
function exportExcelTpl(){
    window.location.href = '${ctx}/pro/exportExcelTpl';
}
function uploadExcel(){
    layui.upload.render({
        elem: '#test9' //绑定元素
        ,url: con.app+'/pro/uploadExcel' //上传接口
        ,accept:'file'
        ,exts:'xls|xlsx'
        ,done: function(res){
            layer.msg("上传成功"); 
            refresh();
        }
        ,error: function(){
          //请求异常回调
        	 layer.msg("上传失败"); 
             refresh();
        }
      });
}
layui.use(['element'], function () {
    var element = layui.element;// 操作对象
});
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="sel">查看{{d.id}}</a>
  <a class="layui-btn layui-btn-xs" lay-event="upd">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>