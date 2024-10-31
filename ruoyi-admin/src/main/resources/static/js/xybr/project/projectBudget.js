//饼图
function createProjectBudget(bar,project) {
    option = {
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
            icon:'circle',
            left: 'center',
            show: true,
        },

        grid: {
            left: '3%',
            right: '4%',
            top: '15%',
            bottom: '10%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ['人力','物料','外测','认证','工装','模具','差旅'],
        },
        yAxis: {
            type: 'value',
        },
        series: [
            {
                name: '预算',
                type: 'bar',
                barWidth: nowSize(30),
                stack: '数量',
                data: [11,20,30,26,53,24,19],
                itemStyle: {
                    normal: {
                        //颜色渐变
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#FC915A'
                        }, {
                            offset: 1,
                            color: '#FBDD76'
                        }])
                    }
                }
            },
            {
                name: '核算',
                type: 'bar',
                barWidth:nowSize(30),
                stack: '数量',
                data:  [11,20,30,26,53,24,19],
                itemStyle: {
                    normal: {
                        //颜色渐变
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#317EEA'
                        }, {
                            offset: 1,
                            color: '#4DB9F6'
                        }])
                    }
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
                bottom: '10%',
                zoomLock: false, //指定是否锁定缩放比例。
                startValue: 0, // 从头开始。
                endValue: 3,// 一次性展示4个
                showDetail: false, // 关闭滚动条提示
                fillerColor: 'rgba(255, 255, 255,0.5)',
            }
        ]
    };
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}