function createMaoLiRate(chart, monthList) {
    let option = {
        backgroundColor: 'rgb(21,51,114, 0)',
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['20kW', '30kW', '40kW'],
            top: '6%',
            align: 'right',
            textStyle: {
                color: "#00c7ff",
                fontSize: nowSize(),
            },
            itemWidth: 10,
            itemHeight: 10,
            itemGap: 35
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '4%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data: ['01',
                '02',
                '03',
                '04',
                '05',
                '06'
            ],
            axisLine: {
                show: true,
                lineStyle: {
                    color: "#063374",
                    width: 1,
                    type: "solid",
                }
            },
            axisTick: {
                show: false,
            },
            axisLabel: {
                show: true,
                textStyle: {
                    color: "#00c7ff",
                    fontSize: nowSize(),
                }
            },
        }],
        yAxis: [{
            type: 'value',
            axisLabel: {
                formatter: '{value}',
                fontSize: nowSize(),
            },
            axisTick: {
                show: false,
            },
            axisLine: {
                show: false,
                lineStyle: {
                    color: "#00c7ff",
                    width: 1,
                    type: "solid",
                    fontSize: nowSize(),
                },
            },
            splitLine: {
                lineStyle: {
                    color: "#063374",
                    fontSize: nowSize(),
                }
            }
        }],
        series: [{
            name: '20kW',
            type: 'bar',
            data: [20, 50, 80, 58, 83, 120],
            barWidth: 10, //柱子宽度
            barGap: 1, //柱子之间间距
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#008cff'
                    }, {
                        offset: 1,
                        color: '#005193'
                    }]),
                    opacity: 1,
                }
            }
        }, {
            name: '30kW',
            type: 'bar',
            data: [50, 70, 60, 61, 75, 87],
            barWidth: 10,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#00da9c'
                    }, {
                        offset: 1,
                        color: '#007a55'
                    }]),
                    opacity: 1,
                }
            }
        }, {
            name: '40kW',
            type: 'bar',
            data: [70, 48, 73, 68, 53, 47],
            barWidth: 10,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#c4e300'
                    }, {
                        offset: 1,
                        color: '#728400'
                    }]),
                    opacity: 1,
                }
            }
        }],
        dataZoom : [
            {
                orient: 'horizontal',
                show: true,//控制滚动条显示隐藏
                realtime: true, //拖动滚动条时是否动态的更新图表数据
                height: 0, //滚动条高度
                start: 0, //滚动条开始位置（共6等份）
                end: this.endValue,//滚动条结束位置
                top: '95%',
                bottom: '4%',
                zoomLock: false, //指定是否锁定缩放比例。
                startValue: 0, // 从头开始。
                endValue: 4,// 一次性展示4个
                showDetail: false, // 关闭滚动条提示
                fillerColor: 'rgba(255, 255, 255,0.5)',
            }
        ]
    };
    $.ajax({
        type: "GET",
        url: urls + "/system/cockpit/getMaoLi",
        contentType: "application/json;charset=utf-8",
        data: {
            "monthStr": monthList
        },
        dateType: "json",
        success: function (data) {
            option.xAxis[0].data = data.monthLists;
            option.series[0].data = data.list20kW;
            option.series[1].data = data.list30kW;
            option.series[2].data = data.list40kW;
            chart.setOption(option,true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    window.addEventListener('resize', function() {
        chart.setOption(option, true);
    });
    function nowSize(){
        let nowClientWidth = 12*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}