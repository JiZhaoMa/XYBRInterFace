//饼图
function createProjectBudget(bar,projectCode) {
    let option = {
        title: {
            text: '',
            subtext: ''
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            icon:'circle',
            left: 'center',
            show: true,
        },

        grid: {
            left: '3%',
            right: '4%',
            top: '15%',
            bottom: '10%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ['累计','人力','外购样机','研发样机','设备购置','工装','模具','外出试验','认证服务','委外设计','差旅','其他'],
        },
        yAxis: {
            type: 'value',
        },
        series: [
            {
                name: '预算',
                type: 'bar',
                barWidth: nowSize(25),
                data: [233,11,70,30,26,53,24,19],
                itemStyle: {
                    normal: {
                        //颜色渐变
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#FC915A'
                        }, {
                            offset: 1,
                            color: '#FBDD76'
                        }])
                    }
                }
            },
            {
                name: '核算',
                type: 'bar',
                barWidth:nowSize(25),
                data:  [333,11,20,80,26,53,24,119],
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
            }
        ],
        dataZoom : [
            {
                orient: 'horizontal',
                show: true,//控制滚动条显示隐藏
                realtime: true, //拖动滚动条时是否动态的更新图表数据
                height: 0, //滚动条高度
                start: 0, //滚动条开始位置（共6等份）
                end: this.endValue,//滚动条结束位置
                bottom: '10%',
                zoomLock: false, //指定是否锁定缩放比例。
                startValue: 0, // 从头开始。
                endValue: 3,// 一次性展示4个
                showDetail: false, // 关闭滚动条提示
                fillerColor: 'rgba(255, 255, 255,0.5)',
            }
        ]
    };
    $.ajax({
        type: "GET",
        url: urls + "report/project/getProjectBudget",
        contentType: "application/json;charset=utf-8",
        data: {
            "projectCode": projectCode
        },
        dateType: "json",
        success: function (data) {
            option.series[0].data = data.yusuanlist; //预算
            option.series[1].data = data.hesuanlist; //核算
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