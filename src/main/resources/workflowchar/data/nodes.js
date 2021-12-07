window.TEST_NODES = [{
    name: '开始',
    nodeNum: 'N1',
    nodeType: 0,
    nodeDetail: '标志流程的开始'
}, {
    name: '审批节点',
    nodeNum: 'N3',
    //控制是否可以多连
    nodeType: 0,
    nodeDetail: '配置审批人和审批规则'
}, {
    name: '网关',
    nodeNum: 'N2',
    nodeType: 1,
    nodeDetail: '一对多，一对一用于多人审批'
}, {
    name: '结束',
    nodeNum: 'N4',
    nodeType: 0,
    nodeDetail: '标志流程结束'
}
];
