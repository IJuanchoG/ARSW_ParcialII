let app = (() => {
    let client = apiclient;

    var mapCity = () => {

    }
    var mapCities = () => {
        map = new google.maps.Map(document.getElementById("map-canvas"), {
            zoom: 2,
            center: {lat: 35.717, lng: 139.731},
        });
    }


    function init() {
        mapCities();
    }

    return {
        init: init,
        consultarCity(name) {
            console.log(name)
            client.getWeatherByName(name, mapCity);
        }
    }
})();