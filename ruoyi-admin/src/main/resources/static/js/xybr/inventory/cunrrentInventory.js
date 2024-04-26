function createCurrentInventory(eChart1, month,agent,urls) {
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
            data: ['实际库存', '安全库存']
        },
        xAxis: [
            {
                type: 'category',
                data: ['A产品', 'B产品', 'C产品', 'D产品', 'E产品', 'F产品','G产品','H产品'],
                axisLabel: {
                    show: true,
                    textStyle: {
                        fontSize: 12,
                        color: '#ffffff'
                    },
                    interval: 0,
                    rotate: 40
                },
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '库存',
                nameTextStyle: {
                    color: '#FFF',
                },
                min: 0,
                max: 2000,
                splitNumber: 5,
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
                name: '实际库存',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    4000, 3000, 4000, 3000, 8000, 4000, 5000, 6000
                ],
                barWidth: '30%',
                itemStyle: {
                    color: '#89be89'
                }
            },
            {
                name: '安全库存',
                type: 'line',
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
                data: [
                    3000, 2000, 3000, 2000, 7000, 3000, 4000, 5000
                ],
                itemStyle: {
                    color: '#e15656'
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
    eChart1.setOption(option1, true);
    $.ajax({
        type: "GET",
        url: urls + "report/inventory/getInventoryOfCurrent",
        contentType: "application/json;charset=utf-8",
        data: {
            "monthStr": month,
            "agent": agent
        },
        dateType: "json",
        success: function (data) {
            option1.xAxis[0].data = data.mmap.productList;
            option1.series[0].data = data.mmap.actStockList;
            option1.series[1].data = data.mmap.safeStockList;
            eChart1.setOption(option1, true);
        },
        error: function (data) {
            alert("失败");
        }

    });

}