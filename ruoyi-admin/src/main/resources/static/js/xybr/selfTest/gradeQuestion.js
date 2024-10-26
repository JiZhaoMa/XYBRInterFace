//饼图
function createGradeBar(bar,project) {
    let option = {
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['低','中','高','紧急']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis:  {
            type: 'value'
        },
        yAxis: {
            type: 'category',
            data: ['已解决','遗留跟踪','遗留不跟踪']
        },
        series: [
            {
                name: '低',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                itemStyle: {
                    normal: {
                        color: 'rgba(51,192,205,0.57)'
                    }
                },
                data: [320, 302, 301, 334]
            },
            {
                name: '中',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                itemStyle: {
                    normal: {
                        color: 'rgba(115,172,255,0.67)'
                    }
                },
                data: [120, 132, 101, 134]
            },
            {
                name: '高',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                itemStyle: {
                    normal: {
                        color: 'rgba(252,75,75,0.57)'
                    }
                },
                data: [220, 182, 191, 234]
            },
            {
                name: '紧急',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                itemStyle: {
                    normal: {
                        color: 'rgba(115,172,255,0.67)'
                    }
                },
                data: [150, 212, 201, 154]
            }
        ]
    };
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}