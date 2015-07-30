 (function($) {
        var plugin = CQ.Ext.extend(CQ.Ext.emptyFn, {
            init: function(widget) {
                // create some JS logic to get the locale here
                // current path can be obtained via
                // widget.findParentByType('dialog').responseScope.path
                widget.treeRoot.name = CQ.HTTP.getPath();
            }
        });
        CQ.Ext.ComponentMgr.registerPlugin('customRootPathPlugin', plugin);
    }($CQ));