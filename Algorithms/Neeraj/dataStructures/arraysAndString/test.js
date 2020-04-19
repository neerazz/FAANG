var GLOBAL = {
  //the id of the form we will use to create calendar events
  formId : "131uJTf-K188p2vx3ndv9dIyX5ASJXzeBYT3dcx6d0vk",

  //the id of the calendar we will create events on
  neeraj_calendarId : "qoj4jo72lc2f6d03ag5de92p9s@group.calendar.google.com",
  sachi_calenderId: "i228rvfhvlb51f10bfneaa58us@group.calendar.google.com",

  //a mapping of form item titles to sections of the
  //calendar event
  formMap : {
    problem: "Question",
    link: "Question Link",
    startTime : "Event Date and Start Time",
    endTime: "Event End Time",
    source: "Source",
    level: "Level",
    location: "Source",
    notes: "Notes",
    by: "Solved By",
    thinkingTime:"Timings"
  }
}
function FORM_Function() {
  var neeraj_calender = CalendarApp.getCalendarById(GLOBAL.neeraj_calendarId);
  var sachi_calender = CalendarApp.getCalendarById(GLOBAL.sachi_calenderId);
  var formId = "1FAIpQLSemaM7HIQshrd19AAq3TvhO4fv0EpXHdDA-BLsShxHSzXFN6A"
  // Get a form object by opening the form using the
  // form id stored in the GLOBAL variable object
  var form = FormApp.openById(GLOBAL.formId),
      //Get all responses from the form.
      //This method returns an array of form responses
      responses = form.getResponses(),
      //find the length of the responses array
      length = responses.length,
      //find the index of the most recent form response
      //since arrays are zero indexed, the last response
      //is the total number of responses minus one
      lastResponse = responses[length-1],
      //get an array of responses to every question item
      //within the form
      itemResponses = lastResponse.getItemResponses(),
      //create an empty object to store data from the
      //last form response
      eventObject = {};
  for (var i = 0, x = itemResponses.length; i<x; i++) {
    //Get the title of the form item being iterated on
    var thisItem = itemResponses[i].getItem().getTitle(),
        //get the submitted response to the form item being
        //iterated on
        thisResponse = itemResponses[i].getResponse();
    //based on the form question title, map the response of the
    //item being iterated on into our eventObject variable
    //use the GLOBAL variable formMap sub object to match form
    //question titles to property keys in the event object
    switch (thisItem) {
      case GLOBAL.formMap.problem:
        eventObject.problem = thisResponse;
        break;
      case GLOBAL.formMap.link:
        eventObject.link = thisResponse;
        break;
      case GLOBAL.formMap.source:
        eventObject.source = thisResponse;
        break;
      case GLOBAL.formMap.level:
        eventObject.level = thisResponse;
        break;
      case GLOBAL.formMap.location:
        eventObject.location = thisResponse;
        break;
      case GLOBAL.formMap.notes:
        eventObject.notes = thisResponse;
        break;
      case GLOBAL.formMap.by:
        eventObject.by = thisResponse;
        break;
      case GLOBAL.formMap.thinkingTime:
        eventObject.thinkingTime = thisResponse[0];
        eventObject.implementingTime = thisResponse[1];
        break;
      case GLOBAL.formMap.implementingTime:
        eventObject.implementingTime = thisResponse;
        break;
    }
  }
  if(eventObject.thinkingTime === 'Unsolved' || eventObject.implementingTime === 'Unsolved'){
    createEvent(eventObject.by,eventObject);
  }
}

function createEvent(by,eventObject){
    var description = "Problem :" + eventObject.problem + "\n" +
                        "Link: " + eventObject.link + "\n" +
                        "Source:" + eventObject.source + "\n" +
                        "Notes:" + eventObject.notes;
    var event = {
        'location': eventObject.location,
        'description': description
    }
    var summary = "Solve " + eventObject.problem + " problem ";
        var start = new Date();
        var end = new Date();
        start.setDate(start.getDate() + 2);
        end.setTime(start.getTime() + 30*60* 1000);
    if(eventObject.by === 'Neeraj'){
      CalendarApp.getCalendarById(GLOBAL.neeraj_calendarId).createEvent(summary, start,end,event);
    }
    if(eventObject.by === 'Sachi'){
      sachi_calender.createEvent(summary, start,end,eventObject);
    }
}