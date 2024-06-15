function createyuQiClient(yuQiClientBar, month) {
    xData = ['客户一', '客户二', '客户三', '客户四', '客户五', '客户六'];
    yData = [5752, 1230, 425, 2443, 1230, 5547];
    option = {
        backgroundColor: 'rgb(21,51,114, 0)',
        grid: {
            top: '25%',
            left: '-5%',
            bottom: '5%',
            right: '5%',
            containLabel: true,
        },
        tooltip: {
            show: true,
        },
        animation: false,
        xAxis: [
            {
                type: 'category',
                data: xData,
                axisTick: {
                    alignWithLabel: true,
                },
                nameTextStyle: {
                    color: '#82b0ec',
                },
                axisLine: {
                    show: false,
                    lineStyle: {
                        color: '#82b0ec',
                    },
                },
                axisLabel: {
                    textStyle: {
                        color: '#00c7ff',
                    },
                    margin: 30,
                    rotate: 30
                },
            },
        ],
        yAxis: [
            {
                show: false,
                type: 'value',
                axisLabel: {
                    textStyle: {
                        color: '#fff',
                    },
                },
                splitLine: {
                    lineStyle: {
                        color: '#0c2c5a',
                    },
                },
                axisLine: {
                    show: false,
                },
            },
        ],
        series: [
            {
                name: '',
                type: 'pictorialBar',
                symbolSize: [40, 10],
                symbolOffset: [0, -6], // 上部椭圆
                symbolPosition: 'end',
                z: 12,
                // "barWidth": "0",
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        // "formatter": "{c}%"
                        fontSize: 15,
                        fontWeight: 'bold',
                        color: '#34DCFF',
                    },
                },
                color: '#2DB1EF',
                data: yData,
            },
            {
                name: '',
                type: 'pictorialBar',
                symbolSize: [40, 10],
                symbolOffset: [0, 7], // 下部椭圆
                // "barWidth": "20",
                z: 12,
                color: '#2DB1EF',
                data: yData,
            },
            {
                name: '',
                type: 'pictorialBar',
                symbolSize: function (d) {
                    return d > 0 ? [50, 15] : [0, 0]
                },
                symbolOffset: [0, 12], // 下部内环
                z: 10,
                itemStyle: {
                    normal: {
                        color: 'transparent',
                        borderColor: '#2EA9E5',
                        borderType: 'solid',
                        borderWidth: 1,
                    },
                },
                data: yData,
            },
            {
                name: '',
                type: 'pictorialBar',
                symbolSize: [70, 20],
                symbolOffset: [0, 18], // 下部外环
                z: 10,
                itemStyle: {
                    normal: {
                        color: 'transparent',
                        borderColor: '#19465D',
                        borderType: 'solid',
                        borderWidth: 2,
                    },
                },
                data: yData,
            },
            {
                type: 'bar',
                //silent: true,
                barWidth: '40',
                barGap: '10%', // Make series be overlap
                barCateGoryGap: '10%',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 0.7, [
                            {
                                offset: 0,
                                color: '#38B2E6',
                            },
                            {
                                offset: 1,
                                color: '#0B3147',
                            },
                        ]),
                        opacity: 0.8,
                    },
                },
                data: yData,
            },
        ],
    };

    yuQiClientBar.setOption(option, true);
}