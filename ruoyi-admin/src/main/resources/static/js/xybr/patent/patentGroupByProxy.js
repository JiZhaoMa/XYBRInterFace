//饼图
function createPatentGroupByProxy(bar,person,dept,ptype,process,jiaoDiShuMonth,shouQuanMonth) {
    let xAxisData = [];
    let faMingData = [];
    let shiYongData = [];
    let waiGuanData = [];
    let option = {
        title: {
            text: '',
            subtext: ''
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['发明', '实用新型', '外观设计'],
            align: 'left',
            right: 0,
            textStyle: {
                color: "#333",
                fontSize: nowSize(14),
            },
            itemWidth: nowSize(14),
            itemHeight: nowSize(14),
        },

        grid: {
            left: '0',
            right: '0',
            bottom: '8%',
            top: '15%',
            containLabel: true
        },
        label: {
            show: true,
            position: 'inside',
            color: '#fff',
            fontSize: nowSize(14),
            formatter: function (params){
                if(params.value === 0){
                    return '';
                }
                return params.value;
            }
        },
        xAxis: {

            type: 'category',
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            data: xAxisData,
            axisLabel: {
                textStyle: {
                    color: "#333",
                    fontSize: nowSize(12)
                },
            }

        },
        yAxis: {
            type: 'value',
            axisLabel: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            splitLine: {
                show: false
            }
        },
        series: [
            {
                name: '发明',
                type: 'bar',
                barWidth: 30,
                stack: '数量',
                data: faMingData,
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(12)
                        },
                        color: '#00999b'
                    }
                }
            },
            {
                name: '实用新型',
                type: 'bar',
                barWidth:30,
                stack: '数量',
                data:  shiYongData,
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(12)
                        },
                        color: '#345e37'
                    }
                }
            },
            {
                name: '外观设计',
                type: 'bar',
                barWidth: 30,
                stack: '数量',
                data:  waiGuanData,
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(12)
                        },
                        color: '#bb2649'
                    }
                }
            },

        ]
    };
    $.ajax({
        type: "GET",
        url: urls + "report/patent/getPatentByProxy",
        contentType: "application/json;charset=utf-8",
        data: {
            "dept": dept,
            "person": person,
            "ptype": ptype,
            "process": process,
            "jiaoDiShuMonth": jiaoDiShuMonth,
            "shouQuanMonth": shouQuanMonth,
        },
        dateType: "json",
        success: function (data) {
            option.xAxis.data = data.xAxisData;
            option.series[0].data = data.faMingData;
            option.series[1].data = data.shiYongData;
            option.series[2].data = data.waiGuanData;
            bar.setOption(option,true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    window.addEventListener('resize', function() {
        bar.setOption(option, true);
    });
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}