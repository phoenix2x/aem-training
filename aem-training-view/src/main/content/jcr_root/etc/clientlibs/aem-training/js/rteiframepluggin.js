/*
 * Copyright 1997-2010 Day Management AG
 * Barfuesserplatz 6, 4001 Basel, Switzerland
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Day Management AG, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Day.
 */

/**
 * @class Ejst.IFramePlugin
 * @extends CQ.form.rte.plugins.Plugin
 * This is a custom RTE Plug-in based on {@link CQ.form.rte.plugins.Plugin}.
 * Clicking the toolbar button opens a dialog that allows inserting a text.
 * @constructor
 * Creates a new IFramePlugin.
 * @param {Object} config The config object
 */

var Ejst = Ejst || {};

//Ejst.IFramePlugin = CQ.Ext.extend(CQ.form.rte.plugins.Plugin, {
//
//    /**
//     * @private
//     */
//    insertTextUI: null,
//
//    /**
//     * @private
//     */
//    insertTextDialog: null,
//
//    /**
//     * @private
//     */
//    savedRange: null,
//
//    constructor: function(editorKernel) {
//        Ejst.IFramePlugin.superclass.constructor.call(this, editorKernel);
//    },
//
//    getFeatures: function() {
//        return [ "myiframe" ];
//    },
//
//    initializeUI: function(tbGenerator) {
//        var plg = CQ.form.rte.plugins;
//        var ui = CQ.form.rte.ui;
//        if (this.isFeatureEnabled("myiframe")) {
//            this.insertTextUI = new ui.TbElement("myiframe", this, false,
//                    this.getTooltip("myiframe"));
//            tbGenerator.addElement("misc", plg.Plugin.SORT_MISC, this.insertTextUI, 200);
//        }
//    },
//
//    /**
//     * Inserts a text using the corresponding dialog.
//     * @private
//     */
//    insertText: function(context) {
//        if (!this.insertTextDialog) {
//            var dialogConfig = this.config.dialogConfig || { };
//            this.insertTextDialog = new Ejst.IFramePlugin.Dialog(dialogConfig);
//        }
//        this.insertTextDialog.editContext = context;
//        this.insertTextDialog.plugin = this;
//        if (CQ.Ext.isIE) {
//            this.savedRange = context.doc.selection.createRange();
//        }
//        this.insertTextDialog.setPosition(this.editorKernel.calculateWindowPosition());
//        this.insertTextDialog.show();
//        window.setTimeout(function() {
//            this.insertTextDialog.toFront();
//        }.createDelegate(this), 10);
//    },
//
//    executeInsertText: function(context, iframeurl, iframetitle, size) {
//        if (CQ.Ext.isIE) {
//            this.savedRange.select();
//        }
//        var selection = CUI.rte.Selection.createProcessingSelection(context);
//        var rteText = selection.startNode.wholeText;
//        this.editorKernel.relayCmd("InsertHTML", "<a _rte_href=" + iframeurl + " href=" + iframeurl + " data-size=" + size + " data-title=" + iframetitle + " class='my-iframe-href'>" + rteText + "</a>");
//    },
//
//    notifyPluginConfig: function(pluginConfig) {
//        // configuring "special characters" dialog
//        pluginConfig = pluginConfig || { };
//        var defaults = {
//            "tooltips": {
//                "myiframe": {
//                    "title": CQ.I18n.getMessage("Insert iFrame"),
//                    "text": CQ.I18n.getMessage("Create or modify a iFrame link.")
//                }
//            }
//        };
//        CQ.Util.applyDefaults(pluginConfig, defaults);
//        this.config = pluginConfig;
//    },
//
//    execute: function(id, value, options) {
//        var context = options.editContext;
//        if (id == "myiframe") {
//            this.insertText(context);
//        }
//    },
//
//    updateState: function(selDef) {
//        var isCreateLinkEnabled = selDef.isSelection;
//        if (this.insertTextUI) {
//            this.insertTextUI.setDisabled(!isCreateLinkEnabled);
//        }
//    }
//
//});
//
//
//// register plugin
//CQ.form.rte.plugins.PluginRegistry.register("myiframe", Ejst.IFramePlugin);
//
//
//Ejst.IFramePlugin.Dialog = CQ.Ext.extend(CQ.Ext.Window, {
//
//    constructor: function(config) {
//        config = config || { };
//        var dialogRef = this;
//        var defaults = {
//            "title": CQ.I18n.getMessage("IFrame Link Editor"),
//            "modal": true,
//            "width": 400,
//            "height": 160,
//            "layout": "fit",
//            "items": [ {
//                    "xtype": "panel",
//                    "layout": "fit",
//                    "bodyStyle": "overflow: auto;",
//                    "stateful": false,
//                    "items": [ {
//                            "border": false,
//                            "xtype": "form",
//                            "stateful": false,
//                            "items": [ {
//	                                "itemId": "iframeurl",
//	                                "name": "iframeurl",
//	                                "allowBlank":false,
//	                                "anchor": CQ.themes.Dialog.ANCHOR,
//	                                "fieldLabel": CQ.I18n.getMessage("IFrame Url:"),
//	                                "xtype": "textfield"
//	                            },{
//                                    "itemId": "iframetitle",
//                                    "name": "iframetitle",
//                                    "anchor": CQ.themes.Dialog.ANCHOR,
//                                    "fieldLabel": CQ.I18n.getMessage("IFrame Title"),
//                                    "xtype": "textfield"
//	                            },{
//                                    "xtype": "sizefield",
//                                    "fieldLabel": "IFrame Dialog Size",
//                                    "fieldDescription": "Optional: Fill first field for width and second for height.",
//                                    "name":"size",
//                                    "itemId": "size"
//	                            }],
//                            "afterrender": function() {
//                                this.body.addClass("cq-rte-basewindow");
//                                dialogRef.dialogItems = this.items;
//                                dialogRef.form = this.getForm();
//                            }
//                        }
//                    ]
//                }
//            ],
//            "buttons": [ {
//                    "itemId": "okButton",
//                    "name": "okButton",
//                    "text": CQ.I18n.getMessage("OK"),
//                    "handler": this.apply,
//                    "disabled": false,
//                    "scope": this
//                }, {
//                    "itemId": "cancelButton",
//                    "name": "cancelButton",
//                    "text": CQ.I18n.getMessage("Cancel"),
//                    "handler": this.cancel,
//                    "disabled": false,
//                    "scope": this
//                }
//            ]
//        };
//        CQ.Util.applyDefaults(config, defaults);
//        Ejst.IFramePlugin.Dialog.superclass.constructor.call(this, config);
//    },
//
//    apply: function() {
//        console.dir(this);
//        var iframeurl = this.items.items[0].items.items[0].items.get("iframeurl").getValue();
//        var iframetitle = this.items.items[0].items.items[0].items.get("iframetitle").getValue();
//        var size = this.items.items[0].items.items[0].items.get("size").getValue();
//        this.hide();
//        this.plugin.executeInsertText(this.editContext, iframeurl, iframetitle, size);
//    },
//
//    cancel: function() {
//        this.hide();
//        this.plugin.editorKernel.deferFocus();
//    }
//
//});
/*************************************************************************
*
* ADOBE CONFIDENTIAL
* ___________________
*
*  Copyright 2012 Adobe Systems Incorporated
*  All Rights Reserved.
*
* NOTICE:  All information contained herein is, and remains
* the property of Adobe Systems Incorporated and its suppliers,
* if any.  The intellectual and technical concepts contained
* herein are proprietary to Adobe Systems Incorporated and its
* suppliers and are protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material
* is strictly forbidden unless prior written permission is obtained
* from Adobe Systems Incorporated.
**************************************************************************/

/**
 * @class CUI.rte.plugins.LinkPlugin
 * @extends CUI.rte.plugins.Plugin
 * <p>This class implements links and anchors as a plugin.</p>
 * <p>The plugin ID is "<b>links</b>".</p>
 * <p><b>Features</b></p>
 * <ul>
 *   <li><b>modifylink</b> - adds a button to create and modify links</li>
 *   <li><b>unlink</b> - adds a button to remove existing links</li>
 *   <li><b>anchor</b> - adds a button to define anchors</li>
 * </ul>
 */
Ejst.IFramePlugin = new Class({

    toString: "myiframe",

    extend: CUI.rte.plugins.Plugin,

    /**
     * @private
     */
    linkDialog: null,

    /**
     * @private
     */
    linkUI: null,

    /**
     * @private
     */
    removeLinkUI: null,

    getFeatures: function() {
        return [ "myiframe" ];
    },

    /**
     * Creates a link using the internal link dialog.
     * @private
     */
    modifyLink: function(context) {
        var com = CUI.rte.Common;
        var dm = this.editorKernel.getDialogManager();
        var dh = CUI.rte.ui.DialogHelper;
        if (!this.linkDialog || dm.mustRecreate(this.linkDialog)) {
            var dialogHelper = dm.createDialogHelper();
            var linkRules = this.editorKernel.htmlRules.links;
            var dialogConfig = {
                "configVersion": 1,
                "defaultDialog": {
                    "dialogClass": {
                        "type": dh.TYPE_DIALOG
                    },
                    "dialogProperties": {
                        "width" : 500,
                        "height": 200,
                        "title": CQ.I18n.getMessage("IFrame Link Editor"),
                        "dialogItems":  []
                    }
                },
                "parameters": {
                    "linkRules": linkRules,
                    "editorKernel": this.editorKernel,
                    "command": this.pluginId + "#modifylink"
                }
            };
            this.config.linkDialogConfig = this.config.linkDialogConfig || {};
            this.config.linkDialogConfig.linkAttributes = this.config.linkDialogConfig.linkAttributes || {};

            if (this.config.linkDialogConfig) {
                var addDialogConfig = this.config.linkDialogConfig;
                if (addDialogConfig.linkAttributes) {
                    com.removeJcrData(addDialogConfig.linkAttributes);
                    var linkAttribs = com.toArray(addDialogConfig.linkAttributes);
                    linkAttribs.push(
                                  {
                                      xtype: dh.TYPE_TEXTFIELD,
                                      attribute: 'href',
                                      fieldLabel: CQ.I18n.getMessage('IFrame URl'),
                                      allowBlank:false,
                                      anchor: CQ.themes.Dialog.ANCHOR
                                  },
                                  {
                                      xtype: dh.TYPE_TEXTFIELD,
                                      attribute: 'data-title',
                                      fieldLabel: CQ.I18n.getMessage('IFrame Title'),
                                      anchor: CQ.themes.Dialog.ANCHOR
                                  },
                                  {
                                      xtype: 'sizefield',
                                      attribute: 'data-size',
                                      fieldLabel:  CQ.I18n.getMessage('IFrame Dialog Size'),
                                      fieldDescription: "Optional: Fill first field for width and second for height.",
                                      anchor: CQ.themes.Dialog.ANCHOR
                                  }
                    );
                    dialogConfig.additionalFields = [ ];
                    var attribCnt = linkAttribs.length;
                    for (var a = 0; a < attribCnt; a++) {
                        var attrib = linkAttribs[a];
                        var type = attrib.type || attrib.xtype;
                        var attribName = attrib.attribute;
                        var attribLabel = attrib.label || attrib.fieldLabel;
                        var itemData = {
                            "item": dialogHelper.createItem(type, attribName, attribLabel),
                            "fromModel": function(obj, field) {
                                if (dialogHelper.getItemType(field) == dh.TYPE_HIDDEN) {
                                    return;
                                }
                                var attribName = dialogHelper.getItemName(field);
                                var attribValue = com.getAttribute(obj.dom, attribName);
                                if (attribValue) {
                                    dialogHelper.setItemValue(field, attribValue);
                                } else {
                                    dialogHelper.setItemValue(field, "");
                                }
                            },
                            "toModel": function(obj, field) {
                                var attribName = dialogHelper.getItemName(field);
                                if (!obj.attributes) {
                                    obj.attributes = { };
                                }
                                var value = dialogHelper.getItemValue(field);
                                if (value && (value.length > 0)) {
                                    obj.attributes[attribName] = value;
                                } else {
                                    obj.attributes[attribName] =
                                        CUI.rte.commands.Link.REMOVE_ATTRIBUTE;
                                }
                            }
                        };
                        delete attrib.attribute;
                        delete attrib.type;
                        delete attrib.xtype;
                        delete attrib.label;
                        delete attrib.fieldLabel;
                        CUI.rte.Utils.applyDefaults(itemData.item, attrib);
                        dialogConfig.additionalFields.push(itemData);
                    }
                    delete addDialogConfig.linkAttributes;
                }
                dialogConfig.dialogProperties = addDialogConfig;
            }
            if (linkRules.targetConfig) {
                if (linkRules.targetConfig.mode != "blank") {
                    dialogConfig.disabledDefaultFields = [ "targetBlank" ];
                }
                if (linkRules.targetConfig.mode == "manual") {
                    if (!dialogConfig.additionalFields) {
                        dialogConfig.additionalFields = { };
                    }
                    var targetItem = dialogHelper.createItem(dh.TYPE_TEXTFIELD, "target",
                            CUI.rte.Utils.i18n("Anchor"));
                    dialogConfig.additionalFields.push({
                        "item": targetItem,
                        "fromModel": function(obj, field) {
                            if (obj.dom && obj.dom["target"]) {
                                dialogHelper.setItemValue(field, obj.dom["target"]);
                            }
                        },
                        "toModel": function(obj, field) {
                            if (!obj.attributes) {
                                obj.attributes = { };
                            }
                            var value = dialogHelper.getItemValue(field);
                            if (value && (value.length > 0)) {
                                obj.attributes["target"] = value;
                            } else {
                                obj.attributes["target"] = null;
                            }
                        }
                    });
                }
            }
            CUI.rte.Utils.applyDefaults(dialogConfig, this.config.linkDialogConfig || { });
            dialogHelper.configure(dialogConfig);
            this.linkDialog = dialogHelper.create();
            dialogHelper.calculateInitialPosition();
        }
        var linkToEdit = null;
        var selectionDef = this.editorKernel.analyzeSelection();
        if (selectionDef.anchorCount == 1) {
            linkToEdit = selectionDef.anchors[0];
        }
        linkToEdit = linkToEdit || { };
        if (typeof linkToEdit.attributes === 'undefined')
            linkToEdit.attributes = { };
        this.linkDialog.initializeEdit(this.editorKernel, linkToEdit,
                CUI.rte.Utils.scope(this.applyLink, this));
        if (com.ua.isIE) {
            this.savedRange = context.doc.selection.createRange();
        }
        dm.show(this.linkDialog);
    },

    applyLink: function(context) {
        var com = CUI.rte.Common;
        var linkObj = this.linkDialog.objToEdit;
        if (linkObj) {
            var linkUrl = linkObj.href;
            var cssClass = linkObj.cssClass ? linkObj.cssClass + "my-iframe-href": "my-iframe-href";
            var target = linkObj.target;
            if (com.ua.isIE) {
                this.savedRange.select();
            }
            this.editorKernel.relayCmd("modifylink", {
                "url": linkUrl,
                "css": cssClass,
                "target": target,
                "trimLinkSelection": this.config.trimLinkSelection,
                "attributes": linkObj.attributes
            });
        }
    },

    initializeUI: function(tbGenerator) {
        var plg = CUI.rte.plugins;
        var ui = CUI.rte.ui;
        if (this.isFeatureEnabled("myiframe")) {
            this.linkUI = tbGenerator.createElement("myiframe", this, false,
                    this.getTooltip("myiframe"));
            tbGenerator.addElement("misc", plg.Plugin.SORT_LINKS, this.linkUI, 10);
        }
    },

    notifyPluginConfig: function(pluginConfig) {
        pluginConfig = pluginConfig || { };
        CUI.rte.Utils.applyDefaults(pluginConfig, {
            "features": "*",
            "trimLinkSelection": true,
            "linkDialogConfig": {
                "targetConfig": {
                    "mode": "manual"
                }
            },
            "anchorDialogConfig": {
                // empty by default
            },
            "tooltips": {
                "modifylink": {
                    "title": CUI.rte.Utils.i18n("My IFrame"),
                    "text": CUI.rte.Utils.i18n("Create or modify a iFrame hyperlink.")
                }
            }
        });
        this.config = pluginConfig;
    },

    execute: function(cmd, value, env) {
        if (cmd == "myiframe") {
            this.modifyLink(env.editContext);
        } else {
            this.editorKernel.relayCmd(cmd);
        }
    },

    updateState: function(selDef) {
        var hasSingleAnchor = selDef.anchorCount == 1;
        var hasNoAnchor = selDef.anchorCount == 0;
        var selectedNode = selDef.selectedDom;
        var isLinkableObject = false;
        if (selectedNode) {
            isLinkableObject = CUI.rte.Common.isTag(selectedNode,
                    CUI.rte.plugins.LinkPlugin.LINKABLE_OBJECTS);
        }
        var isCreateLinkEnabled = hasSingleAnchor
                || ((selDef.isSelection || isLinkableObject) && hasNoAnchor);
        if (this.linkUI) {
            this.linkUI.setDisabled(!isCreateLinkEnabled);
        }
    }

});

/**
 * Array with tag names that define objects (like images) that are linkable when selected
 * @private
 * @static
 * @final
 * @type String[]
// */
//CUI.rte.plugins.LinkPlugin.LINKABLE_OBJECTS = [
//    "img"
//];


// register plugin
CUI.rte.plugins.PluginRegistry.register("myiframe", Ejst.IFramePlugin);