//饼图
function createCostComp(bar,project) {
    let option = {
        color: ['#37a2da','#32c5e9','#9fe6b8','#ffdb5c','#ff9f7f'],
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: false, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore : {show: false},
                saveAsImage : {show: false}
            }
        },
        calculable : true,
        series : [
            {
                name:'成本构成',
                type:'pie',
                radius : [nowSize(20), nowSize(80)],
                center: ['50%','45%'],
                roseType : 'area',
                data:[
                    {value:10, name:'结构件'},
                    {value:5, name:'电子料'},
                    {value:15, name:'PCB'},
                    {value:25, name:'工艺辅料'},
                    {value:20, name:'其他'}
                ]
            }
        ]
    };
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}