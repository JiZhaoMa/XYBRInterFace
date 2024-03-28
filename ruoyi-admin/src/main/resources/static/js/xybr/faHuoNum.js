function createfaHuoNumPie(eChart1, res) {
    let option1 = {
        title:{

        },
        tooltip: {
            textStyle: {
                fontSize: '16px',
                color: '#000' // 设置文本颜色 默认#FFF
            },
            trigger: 'axis'
        },
        toolbox: {
            feature: {
                //dataView: { show: true, readOnly: false },
                //magicType: { show: true, type: ['bar', 'bar', 'bar', 'line'] },
                /*restore: { show: true },
                saveAsImage: { show: true }*/
            }
        },
        legend: {
            textStyle:{
                color:'#FFFFFF',
                fontSize: 16,
                fontWeight: 'bold'

            },
            data: ['A产品', 'B产品', 'C产品', '总量']
        },
        xAxis: [
            {
                type: 'category',
                data: ['4月', '5月', '6月', '7月', '8月', '9月'],
                axisLabel: {
                    show: true,
                    textStyle: {
                        fontSize: 16,
                        color: '#ffffff'
                    }
                },
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '数量',
                nameTextStyle: {
                    color: '#FFF',
                },
                min: 0,
                max: 10000,
                interval: 2000,
                axisLabel: {
                    textStyle: {
                        fontSize: 12,
                        color: '#ffffff'
                    },
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '总量',
                nameTextStyle: {
                    color: '#FFF',
                },
                min: 0,
                max: 15000,
                interval: 3000,
                axisLabel: {
                    textStyle: {
                        fontSize: 12,
                        color: '#ffffff'
                    },
                    formatter: '{value}'
                }
            }
        ],
        series: [
            {
                name: 'A产品',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    1000, 2000, 2000, 3000, 2000, 4000
                ]
            },
            {
                name: 'B产品',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    2000, 4000, 5000, 4000, 3000, 4000
                ]
            },
            {
                name: 'C产品',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    3000, 4500, 5400, 4100, 3200, 4000
                ]
            },
            {
                name: '总量',
                type: 'line',
                yAxisIndex: 1,
                label: {
                    normal: {
                        show: true, //数据显示
                        position: 'insideBottom',
                        textStyle: {
                            fontWeight: 'bold',
                            color: '#FFFFFF',
                            fontSize: '12px'
                        }
                    }
                },
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [10000, 12000, 9800, 10100, 14000, 9000]
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
                top: '95%',
                bottom: '4%',
                zoomLock: false, //指定是否锁定缩放比例。
                startValue: 0, // 从头开始。
                endValue: 5,// 一次性展示4个
                showDetail: false, // 关闭滚动条提示
                fillerColor: 'rgba(255, 255, 255,0.5)',
            },
            {
                type: 'inside',
                brushSelect: true,
                start: 0,
                end: 5,
                xAxisIndex: [0],
                moveOnMouseMove: true,//是否只平移不缩放
                zoomLock: true,// 鼠标移动触发窗口平移
                zoomOnMouseWheel: false,//鼠标移动能触发窗口缩放
            },
        ]
    };
    eChart1.setOption(option1, true);
}