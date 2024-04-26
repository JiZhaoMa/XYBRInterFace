function createfaHuoNum(eChart1, month,agent,urls) {
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
                data: ['', '', '', '', '', ''],
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
                max: 5000,
                interval: 1000,
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
                max: 5000,
                interval: 1000,
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
                    0, 0, 0, 0, 0, 0
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
                    0, 0, 0, 0, 0, 0
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
                    0, 0, 0, 0, 0, 0
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
                data: [0, 0, 0, 0, 0, 0]
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

    $.ajax({
        type: "GET",
        url: urls + "report/plan/getProductPlanData",
        contentType: "application/json;charset=utf-8",
        data: {
            "monthStr": month,
            "agent": agent
        },
        dateType: "json",
        success: function (data) {
            option1.xAxis[0].data[0] = data.mmap.monthList[0].substring(4,6) + "月";
            option1.xAxis[0].data[1] = data.mmap.monthList[1].substring(4,6) + "月";
            option1.xAxis[0].data[2] = data.mmap.monthList[2].substring(4,6) + "月";
            option1.xAxis[0].data[3] = data.mmap.monthList[3].substring(4,6) + "月";
            option1.xAxis[0].data[4] = data.mmap.monthList[4].substring(4,6) + "月";
            option1.xAxis[0].data[5] = data.mmap.monthList[5].substring(4,6) + "月";

            option1.legend.data[0] = data.mmap.seriseName[0].seriseName;
            option1.legend.data[1] = data.mmap.seriseName[1].seriseName;
            option1.legend.data[2] = data.mmap.seriseName[2].seriseName;

            option1.series[0].name = data.mmap.seriseName[0].seriseName;
            option1.series[1].name = data.mmap.seriseName[1].seriseName;
            option1.series[2].name = data.mmap.seriseName[2].seriseName;

            option1.series[0].data[0] = data.mmap.FirstMonthList.length > 0 ? data.mmap.FirstMonthList[0].faHuoNum : 0;
            option1.series[1].data[0] = data.mmap.FirstMonthList.length > 1 ? data.mmap.FirstMonthList[1].faHuoNum : 0;
            option1.series[2].data[0] = data.mmap.FirstMonthList.length > 2 ? data.mmap.FirstMonthList[2].faHuoNum : 0;
            option1.series[3].data[0] = Number(data.mmap.FirstMonthList.length > 0 ? data.mmap.FirstMonthList[0].faHuoNum : 0) + Number(data.mmap.FirstMonthList.length > 1 ? data.mmap.FirstMonthList[1].faHuoNum : 0) + Number(data.mmap.FirstMonthList.length > 2 ? data.mmap.FirstMonthList[2].faHuoNum : 0);

            option1.series[0].data[1] = data.mmap.SecondMonthList.length > 0 ? data.mmap.SecondMonthList[0].faHuoNum : 0;
            option1.series[1].data[1] = data.mmap.SecondMonthList.length > 1 ? data.mmap.SecondMonthList[1].faHuoNum : 0;
            option1.series[2].data[1] = data.mmap.SecondMonthList.length > 2 ? data.mmap.SecondMonthList[2].faHuoNum : 0;
            option1.series[3].data[1] = Number(data.mmap.SecondMonthList.length > 0 ? data.mmap.SecondMonthList[0].faHuoNum : 0) + Number(data.mmap.SecondMonthList.length > 1 ? data.mmap.SecondMonthList[1].faHuoNum : 0) + Number(data.mmap.SecondMonthList.length > 2 ? data.mmap.SecondMonthList[2].faHuoNum : 0);

            option1.series[0].data[2] = data.mmap.ThirdMonthList.length > 0 ? data.mmap.ThirdMonthList[0].faHuoNum : 0;
            option1.series[1].data[2] = data.mmap.ThirdMonthList.length > 1 ? data.mmap.ThirdMonthList[1].faHuoNum : 0;
            option1.series[2].data[2] = data.mmap.ThirdMonthList.length > 2 ? data.mmap.ThirdMonthList[2].faHuoNum : 0;
            option1.series[3].data[2] = Number(data.mmap.ThirdMonthList.length > 0 ? data.mmap.ThirdMonthList[0].faHuoNum : 0) + Number(data.mmap.ThirdMonthList.length > 1 ? data.mmap.ThirdMonthList[1].faHuoNum : 0) + Number(data.mmap.ThirdMonthList.length > 2 ? data.mmap.ThirdMonthList[2].faHuoNum : 0);

            option1.series[0].data[3] = data.mmap.FourMonthList.length > 0 ? data.mmap.FourMonthList[0].faHuoNum : 0;
            option1.series[1].data[3] = data.mmap.FourMonthList.length > 1 ? data.mmap.FourMonthList[1].faHuoNum : 0;
            option1.series[2].data[3] = data.mmap.FourMonthList.length > 2 ? data.mmap.FourMonthList[2].faHuoNum : 0;
            option1.series[3].data[3] = Number(data.mmap.FourMonthList.length > 0 ? data.mmap.FourMonthList[0].faHuoNum : 0) + Number(data.mmap.FourMonthList.length > 1 ? data.mmap.FourMonthList[1].faHuoNum : 0) + Number(data.mmap.FourMonthList.length > 2 ? data.mmap.FourMonthList[2].faHuoNum : 0);

            option1.series[0].data[4] = data.mmap.FiveMonthList.length > 0 ? data.mmap.FiveMonthList[0].faHuoNum : 0;
            option1.series[1].data[4] = data.mmap.FiveMonthList.length > 1 ? data.mmap.FiveMonthList[1].faHuoNum : 0;
            option1.series[2].data[4] = data.mmap.FiveMonthList.length > 2 ? data.mmap.FiveMonthList[2].faHuoNum : 0;
            option1.series[3].data[4] = Number(data.mmap.FiveMonthList.length > 0 ? data.mmap.FiveMonthList[0].faHuoNum : 0) + Number(data.mmap.FiveMonthList.length > 1 ? data.mmap.FiveMonthList[1].faHuoNum : 0) + Number(data.mmap.FiveMonthList.length > 2 ? data.mmap.FiveMonthList[2].faHuoNum : 0);

            option1.series[0].data[5] = data.mmap.SixMonthList.length > 0 ? data.mmap.SixMonthList[0].faHuoNum : 0;
            option1.series[1].data[5] = data.mmap.SixMonthList.length > 1 ? data.mmap.SixMonthList[1].faHuoNum : 0;
            option1.series[2].data[5] = data.mmap.SixMonthList.length > 2 ? data.mmap.SixMonthList[2].faHuoNum : 0;
            option1.series[3].data[5] = Number(data.mmap.SixMonthList.length > 0 ? data.mmap.SixMonthList[0].faHuoNum : 0) + Number(data.mmap.SixMonthList.length > 1 ? data.mmap.SixMonthList[1].faHuoNum : 0) + Number(data.mmap.SixMonthList.length > 2 ? data.mmap.SixMonthList[2].faHuoNum : 0);

            eChart1.setOption(option1, true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    eChart1.setOption(option1, true);

}