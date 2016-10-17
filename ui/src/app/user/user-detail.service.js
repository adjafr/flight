export default
class UserDetailService {
  /* @ngInject */
  constructor ($http){
    this.$http = $http

    this.searchFlights = function(flight) {
      var promise = this.$http.post('http://localhost:8000/flights/allavailable', flight).success(function (data) {
        return data.data
      }).error(function (data){
        return{"status":false};
      })
      return promise;
    }

    this.saveFlights = function(flightList, id) {
      console.log("I am called");
      var promise = this.$http.post('http://localhost:8000/flights/create/' + id + '/itinerary', flightList).success(function (data) {


      return data.data
    }).error(function (data) {
      return{"status": false};
    })
    return promise;
    }

      this.getAllItinerariesForUser = function(id) {
        var promise = this.$http.get('http://localhost:8000/flights/findall/' + id + '/itinerary').success(function (data) {
          console.dir(data.data)
          return data.data
        }).error(function (data){
          return{"status":false};
        })
        return promise;
      }

      this.mapItinerary = function(flight) {

        console.log(flight)
      }


}
getUser (id) {
  return this.$http
    .get('http://localhost:8000' + '/users/' + id)
    .then((user) => user.data)
}



}
