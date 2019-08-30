<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglibs.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图示</title>
<%@ include file="/common/header.jsp"%>
<meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="/dall/js/echarts.min.js"></script>
</head>
<body>
<div id="main" style="width: 600px;height:400px;"></div>
<div id="main1" style="width: 600px;height:400px;"></div>
<div id="main2" style="width: 600px;height:400px;"></div>
<script type="text/javascript">

var myChart1 = echarts.init(document.getElementById('main1'));
var myChart2 = echarts.init(document.getElementById('main2'));
//初始化echarts
function chushihua(myChart){
    var option = {
        title:{
            text:'商品销售统计'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series:[{
            name:'访问量',
            type:'pie', 
            radius:'90%', 
            data:[
                {value:0,name:'无'},
            ]
        }]
    };

    myChart.setOption(option);   
}

//从数据库读取数据赋值给echarts
function fuzhi(myChart){
    $.ajax({
        //contentType : "application/json",
        type : "GET",
        url : "${ctx}/pro/list",
        dataType : "json",
        success : function(data) {
            //创建一个数组，用来装对象传给series.data，因为series.data里面不能直接鞋for循环
            var servicedata=[];

            for(var i=0;i<data.length;i++){
                var obj=new Object();
                obj.name=data[i].name; 
                obj.value=data[i].sum;
                servicedata[i]=obj;
            }

            myChart.setOption({
                title:{
                text:'ECharts 数据统计'
                },            
                series:[{
                    name:'访问量',
                    type:'pie', 
                    radius:'60%', 
                    data:servicedata,
                }]

            });

        }
    });
}

//初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
chushihua(myChart);
fuzhi(myChart);  


var labelRight = {
	    normal: {
	        position: 'right'
	    }
	};
	option1 = {
	    title: {
	        text: '交错正负轴标签',
	        subtext: 'From ExcelHome',
	        sublink: 'http://e.weibo.com/1341556070/AjwF2AgQm'
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        top: 80,
	        bottom: 30
	    },
	    xAxis: {
	        type : 'value',
	        position: 'top',
	        splitLine: {lineStyle:{type:'dashed'}},
	    },
	    yAxis: {
	        type : 'category',
	        axisLine: {show: false},
	        axisLabel: {show: false},
	        axisTick: {show: false},
	        splitLine: {show: false},
	        data : ['ten', 'nine', 'eight', 'seven', 'six', 'five', 'four', 'three', 'two', 'one']
	    },
	    series : [
	        {
	            name:'生活费',
	            type:'bar',
	            stack: '总量',
	            label: {
	                normal: {
	                    show: true,
	                    formatter: '{b}'
	                }
	            },
	            data:[
	                {value: -0.07, label: labelRight},
	                {value: -0.09, label: labelRight},
	                0.2, 0.44,
	                {value: -0.23, label: labelRight},
	                0.08,
	                {value: -0.17, label: labelRight},
	                0.47,
	                {value: -0.36, label: labelRight},
	                0.18
	            ]
	        }
	    ]
	};
myChart1.setOption(option1);
var data = genData(50);

option2 = {
    title : {
        text: '同名数量统计',
        subtext: '纯属虚构',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        type: 'scroll',
        orient: 'vertical',
        right: 10,
        top: 20,
        bottom: 20,
        data: data.legendData,

        selected: data.selected
    },
    series : [
        {
            name: '姓名',
            type: 'pie',
            radius : '55%',
            center: ['40%', '50%'],
            data: data.seriesData,
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};




function genData(count) {
    var nameList = [
        '赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张', '孔', '曹', '严', '华', '金', '魏', '陶', '姜', '戚', '谢', '邹', '喻', '柏', '水', '窦', '章', '云', '苏', '潘', '葛', '奚', '范', '彭', '郎', '鲁', '韦', '昌', '马', '苗', '凤', '花', '方', '俞', '任', '袁', '柳', '酆', '鲍', '史', '唐', '费', '廉', '岑', '薛', '雷', '贺', '倪', '汤', '滕', '殷', '罗', '毕', '郝', '邬', '安', '常', '乐', '于', '时', '傅', '皮', '卞', '齐', '康', '伍', '余', '元', '卜', '顾', '孟', '平', '黄', '和', '穆', '萧', '尹', '姚', '邵', '湛', '汪', '祁', '毛', '禹', '狄', '米', '贝', '明', '臧', '计', '伏', '成', '戴', '谈', '宋', '茅', '庞', '熊', '纪', '舒', '屈', '项', '祝', '董', '梁', '杜', '阮', '蓝', '闵', '席', '季', '麻', '强', '贾', '路', '娄', '危'
    ];
    var legendData = [];
    var seriesData = [];
    var selected = {};
    for (var i = 0; i < 50; i++) {
        name = Math.random() > 0.65
            ? makeWord(4, 1) + '·' + makeWord(3, 0)
            : makeWord(2, 1);
        legendData.push(name);
        seriesData.push({
            name: name,
            value: Math.round(Math.random() * 100000)
        });
        selected[name] = i < 6;
    }

    return {
        legendData: legendData,
        seriesData: seriesData,
        selected: selected
    };

    function makeWord(max, min) {
        var nameLen = Math.ceil(Math.random() * max + min);
        var name = [];
        for (var i = 0; i < nameLen; i++) {
            name.push(nameList[Math.round(Math.random() * nameList.length - 1)]);
        }
        return name.join('');
    }
}
myChart2.setOption(option2);
</script>
</body>
</html>