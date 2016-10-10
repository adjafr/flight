export default
class ItineraryDetailService {
  /* @ngInject */
  constructor ($http){
    this.$http = $http
    this.createItinerary = function(flight) {
      var promise = this.$http.post('http://localhost:8000/flights/allavailable', flight).success(function (data) {
        return data.data
      }).error(function (data){
        return{"status":false};
      })
      return promise;
    }
  }
}