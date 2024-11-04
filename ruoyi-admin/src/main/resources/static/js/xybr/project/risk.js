function createRisk(bar,project) {
    option = {
        tooltip: {},
        radar: {
            center: ['50%','55%'],
            radius: nowSize(60),
            // shape: 'circle',
            indicator: [
                { name: '需求', max: 10000},
                { name: '技术', max: 10000},
                { name: '成本', max: 10000},
                { name: '质量', max: 10000},
                { name: '计划', max: 10000}
            ],
            name: {
                formatter: '{value}',
                textStyle: {
                    fontSize: nowSize(12),
                    color: '#000' //外圈标签字体颜色
                }
            },
        },
        series: [{
            name: '风险问题',
            type: 'radar',
            // areaStyle: {normal: {}},
            data : [
                {
                    value : [4300, 10000, 2000, 3000, 5000],
                    name : '风险问题',
                    textStyle: {
                        color: 'red' // 设置文字颜色为红色
                    }
                }
            ]
        }]
    };
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}