//饼图
function createCost(bar,project) {
    option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        calculable : true,
        series : [
            {
                name:'实际成本',
                type:'pie',
                radius : [20, 80],
                center : ['25%', '50%'],
                roseType : 'area',
                itemStyle : {
                    normal : {
                        label : {
                            show : false
                        },
                        labelLine : {
                            show : false
                        }
                    },
                    emphasis : {
                        label : {
                            show : false
                        },
                        labelLine : {
                            show : false
                        }
                    }
                },
                data:[
                    {value:1976, name:'结构件'},
                    {value:1092, name:'工艺辅料'},
                    {value:2141, name:'加工费'},
                    {value:519, name:'电子料'},
                    {value:1159, name:'PCB'},
                    {value:2159, name:'其他'},
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