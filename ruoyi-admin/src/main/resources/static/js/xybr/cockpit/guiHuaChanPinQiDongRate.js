function createGuiHuaChanPinQiDongRate(qiJianFeiYongRate, monthStr) {
    var myColor = ['#eb3600', '#d0a00e', '#33FFCC'];
    let option = {
        grid: {
            left: '11%',
            top: '12%',
            right: '10%',
            bottom: '5%',
            containLabel: true
        },
        xAxis: [{
            show: false,
        }],
        yAxis: [{
            axisTick: 'none',
            axisLine: 'none',
            offset: '27',
            axisLabel: {
                textStyle: {
                    color: '#ffffff',
                    fontSize: '12',
                }
            },
            data: ['20kW', '30kW', '40kW']
        }, {
            axisTick: 'none',
            axisLine: 'none',
            axisLabel: {
                textStyle: {
                    color: '#ffffff',
                    fontSize: '12',
                }
            },
            data: ['100', '100', '100']
        }, {
            name: '已规划产品启动率',
            nameGap: '50',
            nameTextStyle: {
                color: '#ffffff',
                fontSize: '12',
            },
            axisLine: {
                lineStyle: {
                    color: 'rgba(0,0,0,0)'
                }
            },
            data: [],
        }],
        series: [{
            name: '条',
            type: 'bar',
            yAxisIndex: 0,
            data: [4, 53, 72],
            label: {
                normal: {
                    show: true,
                    position: 'right',
                    textStyle: {
                        color: '#ffffff',
                        fontSize: '12',
                    }
                }
            },
            barWidth: 10,
            itemStyle: {
                normal: {
                    color: function(params) {
                        var num = myColor.length;
                        return myColor[params.dataIndex % num]
                    },
                }
            },
            z: 2
        }, {
            name: '白框',
            type: 'bar',
            yAxisIndex: 1,
            barGap: '-100%',
            data: [99, 99.5, 99.5],
            barWidth: 15,
            itemStyle: {
                normal: {
                    color: '#0e2147',
                    barBorderRadius: 5,
                }
            },
            z: 1
        }, {
            name: '外框',
            type: 'bar',
            yAxisIndex: 2,
            barGap: '-100%',
            data: [100, 100, 100],
            barWidth: 20,
            itemStyle: {
                normal: {
                    color: function(params) {
                        var num = myColor.length;
                        return myColor[params.dataIndex % num]
                    },
                    barBorderRadius: 5,
                }
            },
            z: 0
        },
            {
                name: '外圆',
                type: 'scatter',
                hoverAnimation: false,
                data: [0, 0, 0],
                yAxisIndex: 2,
                symbolSize: 25,
                itemStyle: {
                    normal: {
                        color: function(params) {
                            var num = myColor.length;
                            return myColor[params.dataIndex % num]
                        },
                        opacity: 1,
                    }
                },
                z: 2
            }
        ],
        dataZoom : [
            {
                orient: 'vertical',
                show: true,//控制滚动条显示隐藏
                realtime: true, //拖动滚动条时是否动态的更新图表数据
                height: 0, //滚动条高度
                start: 0, //滚动条开始位置（共6等份）
                end: this.endValue,//滚动条结束位置
                top: '95%',
                bottom: '4%',
                startValue: 0, // 从头开始。
                endValue: 3,// 一次性展示4个
                zoomLock: false, //指定是否锁定缩放比例。
                showDetail: false, // 关闭滚动条提示
                fillerColor: 'rgba(255, 255, 255,0)',
            }
        ]
    };
    $.ajax({
        type: "GET",
        url: urls + "/system/cockpit/getChanPinQiDongRate",
        contentType: "application/json;charset=utf-8",
        data: {
            "monthStr": monthStr
        },
        dateType: "json",
        success: function (data) {
            option.yAxis[0].data = data.departmentList;
            option.yAxis[1].data = data.guiHuaList;
            option.series[0].data = data.qiDongList;
            option.series[1].data = data.guiHuaList;
            option.series[2].data = data.guiHuaList;
            qiJianFeiYongRate.setOption(option, true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    let dataIndex = 1;
    setInterval(function () {
        // 更新图表的数据
        qiJianFeiYongRate.setOption({
            dataZoom: [{
                startValue: dataIndex,
                endValue: dataIndex+3

            }]
        });
        if (dataIndex === option.yAxis[0].data.length - 3) {
            dataIndex = 0;
        } else {
            dataIndex++;
        }
    }, 3000);
}