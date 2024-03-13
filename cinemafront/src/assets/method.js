import {weekdayPrefixes} from "@/assets/text";

export function reformatDate(dateString) {
  const [year, month, day] = dateString.split('-');
  const formattedDay = day.startsWith('0') ? day.slice(1) : day;
  const formattedMonth = month.startsWith('0') ? month.slice(1) : month;
  return `${formattedDay}.${formattedMonth}.${year}`;
}
export function reformatTime(timeString) {
  const [hour, minute] = timeString.split(':');
  return `${hour}:${minute}`
}
export function getDayName(dateString) {
  const date = new Date(dateString);
  const weekdayIndex = date.getDay();
  return weekdayPrefixes[weekdayIndex];
}
