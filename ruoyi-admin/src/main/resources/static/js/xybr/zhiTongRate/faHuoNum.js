function createfaHuoNum(eChart1, month,agent,series, urls) {
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
            data: ['', '直通率', '直通率目标']
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
                name: '产量',
                nameTextStyle: {
                    color: '#FFF',
                },
                min: 0,
                max: 10000,
                splitNumber: 5,
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
                name: '直通率(%)',
                nameTextStyle: {
                    color: '#FFF',
                },
                min: 0,
                max: 100,
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
                name: '产量',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    4000, 3000, 4000, 3000, 8000, 4000
                ],
                barWidth: '30%',
                itemStyle: {
                    color: '#6be6c1'
                }
            },
            {
                name: '直通率',
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
                        return value + "%";
                    }
                },
                data: [
                    98, 80, 88, 90, 78, 89
                ],
                itemStyle: {
                    color: '#d9e774'
                }
            },
            {
                name: '直通率目标',
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
                        return value + "%";
                    }
                },
                data: [
                    90, 90, 90, 90, 90, 90
                ],
                itemStyle: {
                    color: '#fb3d28'
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
        url: urls + "report/zhiTongRate/getMonthOfZhiTongRate",
        contentType: "application/json;charset=utf-8",
        data: {
            "monthStr": month,
            "agent": agent,
            "seriesName": series
        },
        dateType: "json",
        success: function (data) {
            option1.xAxis[0].data[0] = data.mmap.monthList[0].substring(4,6) + "月";
            option1.xAxis[0].data[1] = data.mmap.monthList[1].substring(4,6) + "月";
            option1.xAxis[0].data[2] = data.mmap.monthList[2].substring(4,6) + "月";
            option1.xAxis[0].data[3] = data.mmap.monthList[3].substring(4,6) + "月";
            option1.xAxis[0].data[4] = data.mmap.monthList[4].substring(4,6) + "月";
            option1.xAxis[0].data[5] = data.mmap.monthList[5].substring(4,6) + "月";

            //option1.legend.data[0] = data.mmap.seriesName;
            option1.series[0].name = series;
            option1.legend.data[0] = series;

            option1.series[0].data[0] = data.mmap.FirstMonthStockList.length > 0 ? data.mmap.FirstMonthStockList[0].productSum : 0;
            option1.series[1].data[0] = data.mmap.FirstMonthZhiTongRateList.length > 0 ? (data.mmap.FirstMonthZhiTongRateList[0].zhiTongRate * 100).toFixed(2) : 0;
            option1.series[2].data[0] = "90.00";

            option1.series[0].data[1] = data.mmap.SecondMonthStockList.length > 0 ? data.mmap.SecondMonthStockList[0].productSum : 0;
            option1.series[1].data[1] = data.mmap.SecondMonthZhiTongRateList.length > 0 ? (data.mmap.SecondMonthStockZhiTongRateList[0].zhiTongRate * 100).toFixed(2) : 0;
            option1.series[2].data[1] = "90.00";

            option1.series[0].data[2] = data.mmap.ThirdMonthStockList.length > 0 ? data.mmap.ThirdMonthStockList[0].productSum : 0;
            option1.series[1].data[2] = data.mmap.ThirdMonthZhiTongRateList.length > 0 ? (data.mmap.ThirdMonthZhiTongRateList[0].zhiTongRate * 100).toFixed(2) : 0;
            option1.series[2].data[2] = "90.00";

            option1.series[0].data[3] = data.mmap.FourMonthStockList.length > 0 ? data.mmap.FourMonthStockList[0].productSum : 0;
            option1.series[1].data[3] = data.mmap.FourMonthZhiTongRateList.length > 0 ? (data.mmap.FourMonthZhiTongRateList[0].zhiTongRate * 100).toFixed(2) : 0;
            option1.series[2].data[3] = "90.00";

            option1.series[0].data[4] = data.mmap.FiveMonthStockList.length > 0 ? data.mmap.FiveMonthStockList[0].productSum : 0;
            option1.series[1].data[4] = data.mmap.FiveMonthZhiTongRateList.length > 0 ? (data.mmap.FiveMonthZhiTongRateList[0].zhiTongRate * 100).toFixed(2) : 0;
            option1.series[2].data[4] = "90.00";

            option1.series[0].data[5] = data.mmap.SixMonthStockList.length > 0 ? data.mmap.SixMonthStockList[0].productSum : 0;
            option1.series[1].data[5] = data.mmap.SixMonthZhiTongRateList.length > 0 ? (data.mmap.SixMonthZhiTongRateList[0].zhiTongRate * 100).toFixed(2) : 0;
            option1.series[2].data[5] = "90.00";

            eChart1.setOption(option1, true);

        },
        error: function (data) {
            alert("失败");
        }

    });
    eChart1.setOption(option1, true);

}