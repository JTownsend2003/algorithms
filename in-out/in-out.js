const fs = require('fs');

const rawData = fs.readFileSync('./resources/times.json')
const data = JSON.parse(rawData);

console.log(countMaxPeopleInTheRoom(data));

function countMaxPeopleInTheRoom(data) {

    const maxPeople = {
        people: 0,
        from: '',
        to: ''
    };

    let currentPeople = 0;

    data.forEach((entry, i) => {

        if(entry.type === 'in') {
            currentPeople += entry.people

            if(currentPeople > maxPeople.people) {
                maxPeople.people = currentPeople;
                maxPeople.from = new Date(entry.timestamp * 1000).toLocaleString();
                maxPeople.to = new Date(data[i + 1].timestamp * 1000).toLocaleString();
            }

        } else {
            currentPeople -= entry.people;
        }

    })
    
    return maxPeople;

}