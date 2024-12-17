//饼图
function createProjectDefect(bar,projectCode) {
    let testType = ['单板', '初样', '正样', '中试'];
    let ceShiWenti = [11,20,30,26];
    let shiZHiWenTi = [11,20,30,26];
    let ziCeWenTi = [11,20,30,26];
    let option = {
        backgroundColor: '#fff',
        tooltip: {
            trigger: "axis",
            padding: [8, 10],
            axisPointer: {
                type: "shadow",
                textStyle: {
                    color: "#000"
                }
            }
        },
        legend: {
            data: ['测试问题', '试制问题', '自测问题'],
            align: 'left',
            right: 0,
            textStyle: {
                color: "#333",
                fontSize: nowSize(14),
            },
            itemWidth: nowSize(14),
            itemHeight: nowSize(14),
        },
        grid: {
            left: '3%',
            right: '4%',
            top: '15%',
            bottom: '10%',
            containLabel: true
        },
        label: {
            show: false,
            position: 'inside',
            color: '#fff',
            fontSize: nowSize(14),
            formatter: function (params){
                if(params.value === 0){
                    return '';
                }
                return params.value;
            }
        },
        xAxis: {
            type: 'category',
            data: testType
        },
        yAxis: [{
            type: 'value'
        }],
        series: [{
            name: '测试问题',
            type: 'bar',
            data: ceShiWenti,
            barWidth:nowSize(14),//柱子宽度
            barGap: nowSize(0.3), //柱子之间间距
            itemStyle: {
                normal: {
                    //颜色渐变
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#FFABAC'
                    }, {
                        offset: 1,
                        color: '#ff9f7f'
                    }])
                }
            }
        }, {
            name: '试制问题',
            type: 'bar',
            data: shiZHiWenTi,
            barWidth: nowSize(14),
            barGap: nowSize(0.3),
            itemStyle: {
                normal: {
                    //颜色渐变
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#317EEA'
                    }, {
                        offset: 1,
                        color: '#4DB9F6'
                    }])
                }
            }
        }, {
            name: '自测问题',
            type: 'bar',
            data: ziCeWenTi,
            barWidth: nowSize(14),
            barGap:nowSize(0.3),
            itemStyle: {
                normal: {
                    //颜色渐变
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#FFF0A0'
                    }, {
                        offset: 1,
                        color: '#ffdb5c'
                    }])
                }
            }
        }]
    };
    $.ajax({
        type: "GET",
        url: urls + "report/project/getProjectDefect",
        contentType: "application/json;charset=utf-8",
        data: {
            "projectCode": projectCode
        },
        dateType: "json",
        success: function (data) {
            option.series[0].data = data.ceShiWenti; //测试问题
            option.series[1].data = data.shiZHiWenTi; //试制问题
            option.series[2].data = data.ziCeWenTi; //自测问题
            option.xAxis.data = data.stageList; //单板  初样 正样 中试
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