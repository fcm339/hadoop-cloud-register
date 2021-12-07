Chart.ready(() => {
    const basicX = 150;
    const startY = 20;
    const endY = 350;
    const newX = 50;
    const newY = 50;

    let _current = null; // 当前选择节点id

    let _showNodeInfo = (data) => {
        if (!data) {
            return;
        }

        let infoPanel = $('.right');
        infoPanel.find('.proc-name').text(data.name || '');
        infoPanel.find('.proc-desc').text(data.desc || '');
    };

    let _hideNodeInfo = () => {
        _showNodeInfo({
            name: '',
            desc: ''
        });
    };

    let _createChart = function() {
        return new Chart($('#demo-chart'), {
            onNodeClick (data) { // 点击节点时触发
                _showNodeInfo(data);
                _current = data.nodeId;
            },
            onNodeDel (data) {
                console.log(data);
                _hideNodeInfo();
            }
        })
    };

    let chart = _createChart();

    //添加开始节点
    let nodeStart = chart.addNode('开始', basicX, startY, {
        class: 'node-start',
        removable: false,
        data: {
            name: '开始',
            //控制是否可以连接多个
            nodeType: 0
        }
    });
    nodeStart.addPort({
        isSource: true
    });

    //添加结束节点
    let nodeEnd = chart.addNode('结束', basicX, endY, {
        class: 'node-end',
        removable: false,
        data: {
            name: '结束',
            nodeType: 0
        }
    });
    nodeEnd.addPort({
        isTarget: true,
        position: 'Top'
    });

    const addNewTask = (name, params) => {
        params = params || {};
        params.data = params.data || {};
        //params.class = 'node-process';
        params.data.nodeType = 1; // 流程节点类型
        let node = chart.addNode(name, newX, newY, params);

        node.addPort({
            isSource: true
        });

        node.addPort({
            isTarget: true,
            position: 'Top'
        });
    };

    //添加开始节点
    const addNewTaskBegin = (name, params) => {
        params = params || {};
        params.data = params.data || {};
        //params.class = 'node-process';
        params.data.nodeType = 1; // 流程节点类型
        let node = chart.addNode(name, newX, newY, params);
        node.addPort({
            isSource: true
        });
    };

    //添加结束节点
    const addNewTaskEnd = (name, params) => {
        params = params || {};
        params.data = params.data || {};
        //params.class = 'node-process';
        params.data.nodeType = 1; // 流程节点类型
        let node = chart.addNode(name, newX, newY, params);

        node.addPort({
            isTarget: true,
            position: 'Top'
        });
    };

    const bindEvent = () => {
         $(".flowchart-panel").on('click', '.btn-add', function(event) {
            let target = $(event.target);
            let node = target.data('node');
            addNewTask(node.name, {
                data: node,
                class: 'node-process'
            });
        });

        $(".flowchart-panel").on('click', '.btn-add-start', function(event) {
            let target = $(event.target);
            let node = target.data('node');
            addNewTaskBegin(node.name, {
                data: node,
                class: 'node-start'
            });
        });

        $(".flowchart-panel").on('click', '.btn-add-gateway', function(event) {
            let target = $(event.target);
            let node = target.data('node');
            addNewTask(node.name, {
                data: node,
                class: 'node-gateway'
            });
        });

        $(".flowchart-panel").on('click', '.btn-add-end', function(event) {
            let target = $(event.target);
            let node = target.data('node');
            addNewTaskEnd(node.name, {
                data: node,
                class: 'node-end'
            });
        });

        $(".btn-save").click(() => {
            $('#jsonOutput').val(JSON.stringify(chart.toJson()));
        });

        $(".btn-load").click(() => {
            if ($('#demo-chart').length === 0) {
                $('<div id="demo-chart"></div>').appendTo($('.middle'));
                chart = _createChart();
            }
            chart.fromJson($('#jsonOutput').val());
        });

        $(".btn-clear").click(() => {
            $('#demo-chart').remove();
            chart.clear();
        });

        // $(".btn-del").click(() => {
        //     if (!_current) {
        //         return;
        //     }

        //     chart.removeNode(_current);
        // });
    };

    bindEvent();

    // 使用测试数据
    let listHtml = '';
    TEST_NODES.forEach(node => {
        if(node.nodeNum==='N1'){
            listHtml += `<li><span class='node-name'>${node.name}</span><a class='btn-add-start' data-id='node.procId' href='javascript:void(0)'>添加</a></li>`;

        }else if(node.nodeNum==='N2'){
            listHtml += `<li><span class='node-name'>${node.name}</span><a class='btn-add-gateway' data-id='node.procId' href='javascript:void(0)'>添加</a></li>`;

        }else if(node.nodeNum==='N3'){
            listHtml += `<li><span class='node-name'>${node.name}</span><a class='btn-add' data-id='node.procId' href='javascript:void(0)'>添加</a></li>`;
        }else{
            listHtml += `<li><span class='node-name'>${node.name}</span><a class='btn-add-end' data-id='node.procId' href='javascript:void(0)'>添加</a></li>`;

        }
    });
    $('.nodes').html(listHtml);
    $('.nodes').find('.btn-add').each(function(index) {
        $(this).data('node', $.extend({}, TEST_NODES[1]));
    });
    $('.nodes').find('.btn-add-gateway').each(function(index) {
        $(this).data('node', $.extend({}, TEST_NODES[2]));
    });
    $('.nodes').find('.btn-add-start').each(function(index) {
        $(this).data('node', $.extend({}, TEST_NODES[0]));
    });
    $('.nodes').find('.btn-add-end').each(function(index) {
        $(this).data('node', $.extend({}, TEST_NODES[3]));
    });
});
