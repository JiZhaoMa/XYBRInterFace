function createChanPinZhiTongRate(line, monthList) {
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
            align: 'left',
            textStyle: {
                color: "#00c7ff",
                fontSize: nowSize(),
            },
            itemWidth: 10,
            itemHeight: 10,
            itemGap: 35
        },
        grid: {
            top: '20%',
            left: '5%',
            right: '5%',
            bottom: '4%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            axisLine: {
                show: true
            },
            axisLabel: {
                color: '#00c7ff',
                fontSize: nowSize(),
            },
            splitLine: {
                show: false
            },
            boundaryGap: false,
            data: ['01', '02', '03', '04', '05', '06'],

        }],

        yAxis: [{
            type: 'value',
            min: 0,
            // max: 140,
            splitNumber: 4,
            splitLine: {
                show: true,
                lineStyle: {
                    color: 'rgba(255,255,255,0.1)',
                    fontSize: nowSize(),
                }
            },
            axisLine: {
                show: false,
            },
            axisLabel: {
                show: false,
                margin: 20,
                textStyle: {
                    color: '#d1e6eb',
                    fontSize: nowSize(),

                },
            },
            axisTick: {
                show: false,
            },
        }],
        series: [{
            name: '20kW',
            type: 'line',
            // smooth: true, //是否平滑
            showAllSymbol: true,
            // symbol: 'image://./static/images/guang-circle.png',
            symbol: 'circle',
            symbolSize: 5,
            lineStyle: {
                normal: {
                    color: "#6c50f3",
                    shadowColor: 'rgba(0, 0, 0, .3)',
                    shadowBlur: 0,
                    shadowOffsetY: 5,
                    shadowOffsetX: 5,
                },
            },
            label: {
                show: true,
                position: 'bottom',
                textStyle: {
                    color: '#6c50f3',
                    fontSize: nowSize(),
                }
            },
            itemStyle: {
                color: "#6c50f3",
                borderColor: "#fff",
                borderWidth: 3,
                shadowColor: 'rgba(0, 0, 0, .3)',
                shadowBlur: 0,
                shadowOffsetY: 2,
                shadowOffsetX: 2,
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(108,80,243,0.3)'
                    },
                        {
                            offset: 1,
                            color: 'rgba(108,80,243,0)'
                        }
                    ], false),
                    shadowColor: 'rgba(108,80,243, 0.9)',
                    shadowBlur: 5
                }
            },
            data: [88, 89, 79, 80, 58, 99 ]
        },
            {
                name: '30kW',
                type: 'line',
                // smooth: true, //是否平滑
                showAllSymbol: true,
                // symbol: 'image://./static/images/guang-circle.png',
                symbol: 'circle',
                symbolSize: 5,
                lineStyle: {
                    normal: {
                        color: "#00ca95",
                        shadowColor: 'rgba(0, 0, 0, .3)',
                        shadowBlur: 0,
                        shadowOffsetY: 5,
                        shadowOffsetX: 5,
                    },
                },
                label: {
                    show: true,
                    position: 'top',
                    textStyle: {
                        color: '#00ca95',
                        fontSize: nowSize(),
                    }
                },

                itemStyle: {
                    color: "#00ca95",
                    borderColor: "#fff",
                    borderWidth: 3,
                    shadowColor: 'rgba(0, 0, 0, .3)',
                    shadowBlur: 0,
                    shadowOffsetY: 2,
                    shadowOffsetX: 2,
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(0,202,149,0.3)'
                        },
                            {
                                offset: 1,
                                color: 'rgba(0,202,149,0)'
                            }
                        ], false),
                        shadowColor: 'rgba(0,202,149, 0.9)',
                        shadowBlur: 5
                    }
                },
                data: [90, 58, 48, 90, 78, 80 ],
            },
            {
                name: '40kW',
                type: 'line',
                // smooth: true, //是否平滑
                showAllSymbol: true,
                // symbol: 'image://./static/images/guang-circle.png',
                symbol: 'circle',
                symbolSize: 5,
                lineStyle: {
                    normal: {
                        color: 'rgba(255, 209, 26, .7)',
                        shadowColor: 'rgba(0, 0, 0, .3)',
                        shadowBlur: 0,
                        shadowOffsetY: 5,
                        shadowOffsetX: 5,
                    },
                },
                label: {
                    show: true,
                    position: 'insideBottomLeft',
                    textStyle: {
                        color: 'rgba(255, 209, 26, .7)',
                        fontSize: nowSize(),
                    }
                },

                itemStyle: {
                    color: 'rgba(255, 209, 26, .7)',
                    borderColor: "#fff",
                    borderWidth: 3,
                    shadowColor: 'rgba(0, 0, 0, .3)',
                    shadowBlur: 0,
                    shadowOffsetY: 2,
                    shadowOffsetX: 2,
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(255, 209, 26, .7)'
                        },
                            {
                                offset: 1,
                                color: 'rgba(0,202,149,0)'
                            }
                        ], false),
                        shadowColor: 'rgba(255, 209, 26, .7)',
                        shadowBlur: 5
                    }
                },
                data: [42, 28, 58, 84, 24, 80 ],
            }
        ],
        dataZoom : [
            {
                orient: 'horizontal',
                show: true,//控制滚动条显示隐藏
                realtime: true, //拖动滚动条时是否动态的更新图表数据
                height: 0, //滚动条高度
                start: this.startValue, //滚动条开始位置（共6等份）
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
        url: urls + "/system/cockpit/getChanPinZhiTongRate",
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
            var end = option.xAxis[0].data.length - 1;
            var start = option.xAxis[0].data.length - 5;
            option.dataZoom[0].startValue = start;
            option.dataZoom[0].endValue = end;
            line.setOption(option,true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    window.addEventListener('resize', function() {
        line.setOption(option, true);
    });
    function nowSize(){
        let nowClientWidth = 12*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}