async function count() {
    let str = document.getElementById("request").value;
    const host = "http://localhost:8080/api/count?str=";
    const response = await fetch(`${host + str}`, { method: 'POST' });
    const json = await response.json();
    document.getElementById("response").innerHTML = `${json.value}`;
}