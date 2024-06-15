//饼图
function createStockPie(newClientPie, agent) {
    let option = {
        tooltip: {
            trigger: 'item'
        },
        series: [
            {
                name:'库存',
                type:'pie',
                selectedMode: 'single',
                radius: [0, '45%'],

                label: {
                    show: true,
                    normal: {
                        color: '#FFF',
                        position: 'inner'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'材料库存', selected:true},
                    {value:679, name:'整机库存'}
                ],
                color: ['#2DB1EF', '#2fffa4'],
            },
            {
                name:'库存',
                type:'pie',
                radius: ['60%', '100%'],
                label: {
                    show: true,
                    normal: {
                        color: '#FFF',
                        position: 'inner'
                    }
                },
                data:[
                    {value:335, name:'20Kw'},
                    {value:310, name:'30Kw'},
                    {value:234, name:'40Kw'},
                    {value:335, name:'20KW'},
                    {value:310, name:'30KW'},
                    {value:234, name:'40KW'},
                ],
                color: ['#2DB1EF', '#2DB1EF', '#2DB1EF', '#2fffa4', '#2fffa4', '#2fffa4'],
            }
        ]
    };
    newClientPie.setOption(option, true);
}