/*global cordova, module*/

module.exports = {
    startCardReader: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "IDTechPlugin", "startCardReader", []);
    },

    stopCardReader: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "IDTechPlugin", "stopCardReader", []);
    }
};
