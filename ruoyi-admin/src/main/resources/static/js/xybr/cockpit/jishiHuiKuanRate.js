function createJishiHuiKuanRate(line, month) {
    option = {

        title: [{
            text: '已完成',
            x: 'center',
            top: '50%',
            textStyle: {
                color: '#FFFFFF',
                fontSize: 18,
                fontWeight: '100',
            }
        }, {
            text: '50%',
            x: 'center',
            top: '38%',
            textStyle: {
                fontSize: '20',
                color: '#FFFFFF',
                fontFamily: 'DINAlternate-Bold, DINAlternate',
                fontWeight: 'bold',
            },
        }],
        backgroundColor: 'rgb(21,51,114, 0)',
        polar: {
            radius: ['82%', '92%'],
            center: ['50%', '50%'],
        },
        angleAxis: {
            max: 120,
            show: false,
        },
        radiusAxis: {
            type: 'category',
            show: true,
            axisLabel: {
                show: false,
            },
            axisLine: {
                show: false,
            },
            axisTick: {
                show: false,
            },
        },
        series: [{
            name: '',
            type: 'bar',
            roundCap: true,
            barWidth: 90,
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(66, 66, 66, .3)',
            },
            data: [60],
            coordinateSystem: 'polar',

            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                        offset: 0,
                        color: '#16CEB9',
                    },
                        {
                            offset: 1,
                            color: '#6648FF',
                        },
                    ]),
                },
            },
        },
            {
                name: '',
                type: 'pie',
                startAngle: 80,
                radius: ['82%'],
                hoverAnimation: false,
                center: ['50%', '50%'],
                itemStyle: {
                    color: 'rgba(66, 66, 66, .1)',
                    borderWidth: 1,
                    borderColor: '#5269EE',
                },
                data: [120],
            },
            {
                name: '',
                type: 'pie',
                startAngle: 80,
                radius: ['72%'],
                hoverAnimation: false,
                center: ['50%', '50%'],
                itemStyle: {
                    color: 'rgba(66, 66, 66, .1)',
                    borderWidth: 1,
                    borderColor: '#5269EE',
                },
                data: [120],
            }
        ],

    };
    line.setOption(option,true);
}