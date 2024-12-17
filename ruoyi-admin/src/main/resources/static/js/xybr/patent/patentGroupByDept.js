//饼图
function createPatentGroupByDept(bar,person,dept,ptype,process,jiaoDiShuMonth,shouQuanMonth) {
    let xAxisData = ['重庆研发中心','中试部','软件开发部','交流桩开发部','新业务开发部','研发平台管理部','开发一部'];
    let faMingData = [11,20,30,26,53,24,19];
    let shiYongData = [11,20,30,26,53,24,19];
    let waiGuanData = [11,20,30,26,53,24,19];
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
                // rotate: 45 // X轴标签倾斜 45 度
                clickable: true,
                interval: 0,
                textStyle: {
                    color: "#333",
                    fontSize: nowSize(12)
                },
                formatter: function (params, index){
                    if(params.length > 4){
                        return params.substring(0, 4);
                    }
                    return params;
                }
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

        ],
        dataZoom : [
            {
                orient: 'horizontal',
                show: true,//控制滚动条显示隐藏
                realtime: true, //拖动滚动条时是否动态的更新图表数据
                height: 0, //滚动条高度
                start: this.startValue, //滚动条开始位置（共6等份）
                end: this.endValue,//滚动条结束位置
                top: '95%',
                bottom: '4%',
                zoomLock: false, //指定是否锁定缩放比例。
                startValue: 0, // 从头开始。
                endValue: 4,// 一次性展示4个
                showDetail: false, // 关闭滚动条提示
                fillerColor: 'rgba(255, 255, 255,0.5)',
            }
        ]
    };
    $.ajax({
        type: "GET",
        url: urls + "report/patent/getPatentByDept",
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