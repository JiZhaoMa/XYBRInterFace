function createMonthInventory(eChart1, month,agent,urls) {
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
            data: ['库存']
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
                name: '库存',
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
            }
        ],
        series: [
            {
                name: '库存',
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
                    5000, 8000, 6500, 9000, 5678, 5643
                ],
                itemStyle: {
                    color: '#e15656'
                }
            }
        ]
    };
    eChart1.setOption(option1, true);
    $.ajax({
        type: "GET",
        url: urls + "report/inventory/getInventoryOfMonth",
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

            option1.series[0].data[0] = data.mmap.list.length > 0 ? data.mmap.list[0] == null ? 0 : data.mmap.list[0].inventoryOfMonthNum : 0;
            option1.series[0].data[1] = data.mmap.list.length > 1 ? data.mmap.list[1] == null ? 0 : data.mmap.list[1].inventoryOfMonthNum : 0;
            option1.series[0].data[2] = data.mmap.list.length > 2 ? data.mmap.list[2] == null ? 0 : data.mmap.list[2].inventoryOfMonthNum : 0;
            option1.series[0].data[3] = data.mmap.list.length > 3 ? data.mmap.list[3] == null ? 0 : data.mmap.list[3].inventoryOfMonthNum : 0;
            option1.series[0].data[4] = data.mmap.list.length > 4 ? data.mmap.list[4] == null ? 0 : data.mmap.list[4].inventoryOfMonthNum : 0;
            option1.series[0].data[5] = data.mmap.list.length > 5 ? data.mmap.list[5] == null ? 0 : data.mmap.list[5].inventoryOfMonthNum : 0;
            eChart1.setOption(option1, true);
        },
        error: function (data) {
            alert("失败");
        }

    });

}