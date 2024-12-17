//饼图
function createCost(bar,projectCode) {
    let option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        calculable : true,
        series : [
            {
                name:'实际成本',
                type:'pie',
                radius : [20, 80],
                center : ['25%', '50%'],
                roseType : 'area',
                itemStyle : {
                    normal : {
                        label : {
                            show : false
                        },
                        labelLine : {
                            show : false
                        }
                    },
                    emphasis : {
                        label : {
                            show : false
                        },
                        labelLine : {
                            show : false
                        }
                    }
                },
                data:[
                    {value:0, name:''}
                ]
            }
        ]
    };
    $.ajax({
        type: "GET",
        url: urls + "report/project/getCost",
        contentType: "application/json;charset=utf-8",
        data: {
            "projectCode": projectCode
        },
        dateType: "json",
        success: function (data) {
            option.series[0].data.pop();
            for(var i=0; i<data.costList.length; i++){
                option.series[0].data.push({
                    name: data.costTypeList[i],
                    value: data.costList[i]
                })
            }
            bar.setOption(option,true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    window.addEventListener('resize', function() {
        bar.setOption(option, true);
    });
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}