function createyuQiClient(yuQiClientBar, monthStr) {
    var dataArr = [
        [5, 20, 36,10, 25, 8, 9],
        [15, 0, 12,24, 35, 7, 10],
        [0, 25, 10,10, 20, 20, 30]
    ];
    var nameArr = ['客户一','客户二','客户三','客户四','客户五','客户六','客户七'];
    let option = {
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['1-6个月', '6-12个月','12个月以上'],
            top: '-1%',
            align: 'right',
            right: 10,
            textStyle: {
                color: "#00c7ff"
            },
            itemWidth: 10,
            itemHeight: 10,
            itemGap: 35
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '5%',
            height: '80%',
            containLabel: true
        },
        xAxis:  {
            type: 'value',
            axisLabel: {
                show: true,
                textStyle: {
                    color: "#00c7ff",
                }
            },
        },
        yAxis: {
            type: 'category',
            data: nameArr,
            axisLabel: {
                textStyle: {
                    color: '#FFF',
                },
                //align: 'justify',
            },
            nameTextStyle: {
                color: '#FFF',
                textAlign: 'justify',
            },
        },
        series: [
            {
                name: '6-9个月',
                type: 'bar',
                stack: '总量',
                barWidth: 15,
                itemStyle:{
                    normal: {
                        color: '#32ffee',
                        barBorderRadius: [20, 20, 20, 20],
                    }
                },
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight',
                        textStyle: {
                            color: "#000",
                        }
                    }
                },
                data: dataArr[0],
                z:  10,
            },
            {
                name: '9-12个月',
                type: 'bar',
                stack: '总量',
                itemStyle:{
                    normal: {
                        color: 'rgba(255, 209, 26, .7)',
                        barBorderRadius: [20, 20, 20, 20],
                    }
                },
                /*itemStyle:{
                    normal: {
                        color: 'rgba(255, 209, 26, .7)',
                        shadowBlur: [0, 0, 0, 10],
                        shadowColor: 'rgba(255, 209, 26, .7)',
                        barBorderRadius: [20, 20, 20, 20],
                        shadowOffsetX: -20,
                    }
                },*/
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight',
                        textStyle: {
                            color: "#000",
                        }
                    }
                },
                data: dataArr[1],
                z: 5,
            },
            {
                name: '12个月以上',
                type: 'bar',
                stack: '总量',
                itemStyle:{
                    normal: {
                        color: '#00c7ff',
                        barBorderRadius: [20, 20, 20, 20],
                    }
                },
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight',
                        textStyle: {
                            color: "#000",
                        }
                    }
                },
                data: dataArr[2],
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
        url: urls + "/system/cockpit/getYuQiData",
        contentType: "application/json;charset=utf-8",
        data: {
            "monthStr": monthStr
        },
        dateType: "json",
        success: function (data) {
            option.yAxis.data = data.nameList;
            option.series[0].data = data.yuQiList01;
            option.series[1].data = data.yuQiList02;
            option.series[2].data = data.yuQiList03;
            yuQiClientBar.setOption(option, true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    let dataIndex = 1;
    setInterval(function () {
        // 更新图表的数据
        yuQiClientBar.setOption({
            dataZoom: [{
                startValue: dataIndex,
                endValue: dataIndex+3

            }]
        });
        if (dataIndex === nameArr.length - 3) {
            dataIndex = 0;
        } else {
            dataIndex++;
        }
    }, 3000);

}