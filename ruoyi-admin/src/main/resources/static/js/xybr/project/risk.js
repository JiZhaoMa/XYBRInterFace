function createRisk(bar,project) {
    option = {
        tooltip: {},
        radar: {
            center: ['50%','55%'],
            radius: nowSize(60),
            // shape: 'circle',
            indicator: [
                { name: '需求', max: 6500},
                { name: '技术', max: 16000},
                { name: '成本', max: 30000},
                { name: '质量', max: 38000},
                { name: '计划', max: 52000}
            ]
        },
        series: [{
            name: '风险问题',
            type: 'radar',
            // areaStyle: {normal: {}},
            data : [
                {
                    value : [4300, 10000, 28000, 35000, 50000],
                    name : '风险问题'
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