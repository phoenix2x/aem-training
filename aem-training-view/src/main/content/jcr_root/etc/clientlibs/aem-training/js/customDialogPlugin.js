 (function($) {
        var plugin = CQ.Ext.extend(CQ.Ext.emptyFn, {
            init: function(widget) {
                // create some JS logic to get the locale here
                // current path can be obtained via
                // widget.findParentByType('dialog').responseScope.path
//                widget.treeRoot.name = CQ.HTTP.getPath();

//add pathfield
//                var panel = widget.findBy(function(comp){
//                            return comp["xtype"] == "panel";
//                        }, widget);
//                if (panel && panel.length > 0) {
//                    var pathField = {
//                                    "xtype": "pathfield",
//                                    fieldLabel: "Select Path",
//                                    style: "margin-bottom: 5px;",
//                                    "width": "100%",
//                                    rootPath: "/content"
//                                    }
//                    panel[0].insert(2,pathField);
//                    panel[0].doLayout();
//                }
//add tab
            var panel = widget.findBy(function(comp){
                        return comp["xtype"] == "tabpanel";
                    }, widget);
                    if (panel && panel.length > 0) {
                        var newPan = CQ.utils.Util.build("/apps/aem-training/components/iframe/dialog/items/items/first.infinity.json")
                        panel[0].insert(2, newPan)
                        newPan.doLayout()
                        panel[0].doLayout()
                    }
                console.log('qw')
            }
        });
        CQ.Ext.ComponentMgr.registerPlugin('customDialogPlugin', plugin);
    }($CQ));